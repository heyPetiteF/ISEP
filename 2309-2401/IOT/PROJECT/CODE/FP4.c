#include <pmsis.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define INPUT_SIZE 2 
#define HIDDEN_SIZE 2
#define OUTPUT_SIZE 1 
#define LEARNING_RATE 0.01 
#define EPOCHS 10000 
#define RAND_MAX 32767

double activation(double x) { 

    return (x > 0) ? x: 0.0; 

} 

double activation_derivative(double x) {
    return (x > 0) ? 1.0 : 0.0;
}
// define neural network weights and bias 

double weights[INPUT_SIZE]; 

double bias; 

// initialize NN paramaters 

//Simple linear congruential random number generator
unsigned int seed = 42; 
unsigned int simple_rand() {
    seed = (seed * 1103515245 + 12345) % RAND_MAX;
    return seed;
}

void initialize() { 

    for (int i = 0; i < INPUT_SIZE; i++) { 
        weights[i] = ((double)simple_rand() / RAND_MAX) * 2 - 1;// initialize random weights 
    } 
    bias = ((double)simple_rand() / RAND_MAX) * 2 - 1; // initialize random bias  
} 

// neural network forward propagation 

double predict(double inputs[]) { 

    double output = 0; 

    for (int i = 0; i < INPUT_SIZE; i++) { 
        output += weights[i] * inputs[i]; 
    } 

    output += bias; 
    return activation(output); 

} 

 

// Train a neural network 

void train(double inputs[], double target) { 

    double prediction = predict(inputs); 

    double error = target - prediction; 

    for (int i = 0; i < INPUT_SIZE; i++) { 
        weights[i] += LEARNING_RATE * error * inputs[i]; 
    } 

    bias += LEARNING_RATE * error; 

} 


void function_core_0(void *arg) {

    initialize();

    double training_data[][INPUT_SIZE] = {{0.1, 0.12}, {1.1, 0.9}, {2.1, 1.98}, {2.89, 3.2}};
    double targets[] = {0, 1, 2, 3};

    for (int epoch = 0; epoch < EPOCHS; epoch++) {
        for (int i = 0; i < sizeof(training_data) / sizeof(training_data[0]); i++) {
            train(training_data[i], targets[i]);
        }
    }
        printf("\n\t***[Core 0] Training the simple NN on the GAP8***"); 
    for (int i = 0; i < sizeof(training_data) / sizeof(training_data[0]); i++) {
        double prediction = predict(training_data[i]);
        printf("\n[Core 0]Input: [%.2f, %.2f], Target: %.2f, Prediction: %lf\n",
               training_data[i][0], training_data[i][1], targets[i], prediction);
    }
}



void function_core_1(void *arg) {

    //initialize();
    
    const int NUM_SAMPLES = 4;
    double random_data[NUM_SAMPLES][INPUT_SIZE];

    for (int i = 0; i < NUM_SAMPLES; i++) {
        for (int j = 0; j < INPUT_SIZE; j++) {
            random_data[i][j] = ((double)simple_rand() / RAND_MAX) * 2 - 1; 
        }
    }
    printf("\n\t***[Core 1] Generating random prediction dataset***");  
    for (int i = 0; i < NUM_SAMPLES; i++) {
        double prediction = predict(random_data[i]); 
        printf("\n[Core 1]Random Input: [%lf, %lf], Prediction: %lf\n",
               random_data[i][0], random_data[i][1], prediction);
    }

}



void function_core_2(void *arg) {

    initialize();

    double weights_input_hidden[INPUT_SIZE][HIDDEN_SIZE] = {{0.15, 0.25}, {0.20, 0.30}};
    double weights_hidden_output[HIDDEN_SIZE][OUTPUT_SIZE] = {{0.40}, {0.50}};
    double input[INPUT_SIZE] = {1.0, 2.0}; 
    double hidden[HIDDEN_SIZE] = {0};
    double output[OUTPUT_SIZE] = {0};

    for (int i = 0; i < HIDDEN_SIZE; i++) {
        for (int j = 0; j < INPUT_SIZE; j++) {
            hidden[i] += input[j] * weights_input_hidden[j][i];
        }
        hidden[i] = activation(hidden[i]);
    }

    for (int i = 0; i < OUTPUT_SIZE; i++) {
        for (int j = 0; j < HIDDEN_SIZE; j++) {
            output[i] += hidden[j] * weights_hidden_output[j][i];
        }
        output[i] = activation(output[i]);
    }
    printf("\n\t***[Core 2] NN forward propagation function with Hidden_Layer***"); 
    printf("\n[Core 2]Input:(%.2f,%.2f), hidden:%f, Output: %f\n", input[0],input[1], hidden[0], output[0]);
    
}

void function_core_3(void *arg) {

    initialize();

    double weights[2] = {0.5, -0.5}; 
    double input[2] = {0.5, 0.6};  
    double expected_output = 0.7;  
    double output;

    output = activation(input[0] * weights[0] + input[1] * weights[1]);

    double error = expected_output - output;

    for (int i = 0; i < 2; i++) {
        double gradient = error * activation_derivative(output) * input[i];
        weights[i] += LEARNING_RATE * gradient;
    }

    printf("\n\t***[Core 3] NN back propagation function with Hidden_Layer***");
    printf("\n[Core 3]input:(%.2f,%.2f),Updated weights: %f, %f\n",input[0],input[1], weights[0], weights[1]);
}

void function_core_4(void *arg) {

    printf("\n\t***[Core 4] Linear Regression Model***");

    double weights = 0.0; 
    double bias = 0.0;  
    double inputs[] = {1.0, 2.0, 3.0, 4.0};
    double targets[] = {2.0, 4.0, 6.0, 8.0};
    int n_samples = sizeof(inputs) / sizeof(inputs[0]);

    for (int epoch = 0; epoch < EPOCHS; epoch++) {
        for (int i = 0; i < n_samples; i++) {
            double output = inputs[i] * weights + bias;
            double error = targets[i] - output;
            weights += LEARNING_RATE * error * inputs[i];
            bias += LEARNING_RATE * error;
        }
    }
    printf("\n[Core 4]Trained weights: %f, bias: %f\n", weights, bias);
}

void function_core_5(void *arg) {

   printf("\n\t***[Core 5] Logistic Regression Model***");

    double weights = 0.0;
    double bias = 0.0;
    double inputs[] = {0, 1, 2, 3};
    double targets[] = {0, 0, 1, 1}; 
    int n_samples = sizeof(inputs) / sizeof(inputs[0]);

    for (int epoch = 0; epoch < EPOCHS; epoch++) {
        for (int i = 0; i < n_samples; i++) {
            double output = activation(inputs[i] * weights + bias);
            double error = targets[i] - output;
            weights += LEARNING_RATE * error * output * (1 - output) * inputs[i];
            bias += LEARNING_RATE * error * output * (1 - output);
        }
    }
    printf("\n[Core 5]Trained weights: %f, bias: %f\n", weights, bias);
}

void function_core_6(void *arg) {

    printf("\n\t***[Core 6] Multi-Layer Perceptron Model***");

    double weights1 = 0.15, weights2 = 0.25;
    double bias1 = 0.35, bias2 = 0.45;

    double inputs[] = {0.5, 0.6};
    double target = 0.7;
    double hidden_output, final_output;

    for (int epoch = 0; epoch < EPOCHS; epoch++) {
      
        hidden_output = activation(inputs[0] * weights1 + inputs[1] * weights2 + bias1);
        final_output = activation(hidden_output * weights2 + bias2);

        double error = target - final_output;
        weights2 += LEARNING_RATE * error * final_output * (1 - final_output) * hidden_output;
        weights1 += LEARNING_RATE * error * final_output * (1 - final_output) * inputs[0];
        bias2 += LEARNING_RATE * error * final_output * (1 - final_output);
        bias1 += LEARNING_RATE * error * final_output * (1 - final_output);
    }

    printf("\n[Core 6]Trained weights1: %f, weights2: %f, bias1: %f, bias2: %f\n", weights1, weights2, bias1, bias2);
}

void function_core_7(void *arg) {

    printf("\n\t***[Core 7] Simple Classification Model***");

    double weights[] = {0.0, 0.0};
    double bias = 0.0;
    double inputs[][2] = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    double targets[] = {0, 1, 1, 0}; // XOR-like problem
    int n_samples = sizeof(inputs) / sizeof(inputs[0]);

    for (int epoch = 0; epoch < EPOCHS; epoch++) {
        for (int i = 0; i < n_samples; i++) {
            double output = activation(inputs[i][0] * weights[0] + inputs[i][1] * weights[1] + bias);
            double error = targets[i] - output;
            weights[0] += LEARNING_RATE * error * output * (1 - output) * inputs[i][0];
            weights[1] += LEARNING_RATE * error * output * (1 - output) * inputs[i][1];
            bias += LEARNING_RATE * error * output * (1 - output);
        }
    }
    printf("\n[Core 7]Trained weights: [%f, %f], bias: %f\n", weights[0], weights[1], bias);

}


void cluster_core_function(void *arg) {

    uint32_t core_id = pi_core_id();

    switch (core_id) {

        case 0:

            function_core_0(arg);

            break;

        case 1:

            function_core_1(arg);

            break;

        case 2:

            function_core_2(arg);

            break;

        case 3:

            function_core_3(arg);

            break;

        case 4:

            function_core_4(arg);

            break;

        case 5:

            function_core_5(arg);

            break;

        case 6:

            function_core_6(arg);

            break;

        case 7:

            function_core_7(arg);

            break;

        default:

            printf("[Core %d] No specific function assigned\n", core_id);

    }

}



void cluster_delegate(void *arg) {

    printf("\n>>>Entering cluster on core %d\n", pi_core_id());

    pi_cl_team_fork(pi_cl_cluster_nb_cores(), cluster_core_function, arg);

    printf("\n>>>Leaving cluster on core %d\n", pi_core_id());

}


int main(void) {

    printf("\n>>>Entering main controller\n");



    struct pi_device cluster_dev;

    struct pi_cluster_conf cl_conf;

    

    pi_cluster_conf_init(&cl_conf);

    cl_conf.id = 0;

    pi_open_from_conf(&cluster_dev, &cl_conf);



    if (pi_cluster_open(&cluster_dev)) {

        printf("\nCluster open failed!\n");

        return -1;

    }


    struct pi_cluster_task cl_task = {0};

    cl_task.entry = cluster_delegate;

    cl_task.arg = NULL;


    pi_cluster_send_task_to_cl(&cluster_dev, &cl_task);

    pi_cluster_close(&cluster_dev);


    printf("\n>>>Leaving main controller\n");

    return 0;

}


