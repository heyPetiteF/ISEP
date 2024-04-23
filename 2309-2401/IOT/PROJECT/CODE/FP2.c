#include <pmsis.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>


/* Define neural network parameters */
#define INPUT_SIZE 2
#define OUTPUT_SIZE 1
#define LEARNING_RATE 0.001
#define EPOCHS 10000
#define RAND_MAX 32767

/* Define ReLU activated function */
double activation(double x) {
    return (x > 0) ? x : 0.0;
}

/* Define neural network weights and bias */
double weights[INPUT_SIZE];
double bias;

/* Initialize neural network parameters */
void initialize() {
    for (int i = 0; i < INPUT_SIZE; i++) {
        weights[i] = ((double)rand() / RAND_MAX) * 2 - 1; // Initialize random weights
    }
    bias = ((double)rand() / RAND_MAX) * 2 - 1; // Initialize random bias
}

/* Neural network forward propagation */
double predict(double inputs[]) {
    double output = 0;
    for (int i = 0; i < INPUT_SIZE; i++) {
        output += weights[i] * inputs[i];
    }
    output += bias;
    return activation(output);
}

/* Train a neural network */
void train(double inputs[], double target) {
    double prediction = predict(inputs);
    double error = target - prediction;
    for (int i = 0; i < INPUT_SIZE; i++) {
        weights[i] += LEARNING_RATE * error * inputs[i];
    }
    bias += LEARNING_RATE * error;
}

/* Task executed by cluster cores */
void cluster_helloworld(void *arg) {
    uint32_t core_id = pi_core_id(), cluster_id = pi_cluster_id();
    printf("[%d %d] Neural network based on GAP8\n", cluster_id, core_id);
}

/* Cluster main entry, executed by core 0 */
void cluster_delegate(void *arg) {
    printf("\n>>>Cluster master core entry\n");
    /* Task dispatch to cluster cores */
    pi_cl_team_fork(pi_cl_cluster_nb_cores(), cluster_helloworld, arg);
    printf("\n>>>Cluster master core exit\n");
}

void helloworld(void) {
    printf("\n>>>Entering main controller\n");

    uint32_t errors = 0;
    uint32_t core_id = pi_core_id(), cluster_id = pi_cluster_id();
    printf("[%d %d] Neural network based on GAP8\n", cluster_id, core_id);

    struct pi_device cluster_dev;
    struct pi_cluster_conf cl_conf;

    /* Initialize cluster configuration structure */
    pi_cluster_conf_init(&cl_conf);
    cl_conf.id = 0; /* Set cluster ID */

    /* Configure & open cluster */
    pi_open_from_conf(&cluster_dev, &cl_conf);

    pi_perf_conf(1 << PI_PERF_CYCLES | 1 << PI_PERF_ACTIVE_CYCLES);
    pi_perf_reset();
    pi_perf_start();

    if (pi_cluster_open(&cluster_dev)) {
        printf("\n>>>Cluster open failed !\n");
        pmsis_exit(-1);
    }

    pi_perf_stop();
    uint32_t cycles = pi_perf_read(PI_PERF_ACTIVE_CYCLES);
    uint32_t tim_cycles = pi_perf_read(PI_PERF_CYCLES);
    printf("Perf : %d\ncycles Timer : %d cycles\n", cycles, tim_cycles);

    /* Prepare cluster task and send it to cluster */
    struct pi_cluster_task cl_task;
    pi_cluster_send_task_to_cl(&cluster_dev, pi_cluster_task(&cl_task, cluster_delegate, NULL));
    pi_cluster_close(&cluster_dev);

    printf("Test success !\n");

    pmsis_exit(errors);
}

int main(void) {

    double training_data[][INPUT_SIZE] = {{0.1, 0.12}, {1.1, 0.9}, {2.1,1.98}, {2.89, 3.2}}; 

    double targets[] = {0, 1, 2, 3}; 
    
     for (int epoch = 0; epoch < EPOCHS; epoch++) { 

        for (int i = 0; i < sizeof(training_data) / sizeof(training_data[0]); i++) { 

            train(training_data[i], targets[i]); 

        } 

    } 
    
    printf("\n\t*** Neural Network Parameters ***\n");
    
    
    printf("\n>>>Define:\n");
    
    printf("Input Size: %d\n", INPUT_SIZE);
    
    printf("Output Size: %d\n", OUTPUT_SIZE);
    
    printf("Learning Rate: %lf\n", LEARNING_RATE);
    
    printf("Epochs: %d\n", EPOCHS);
    
     printf("\n>>>Neural network parameters:\n");
    
    for (int i = 0; i < sizeof(training_data) / sizeof(training_data[0]); i++) { 

        double prediction = predict(training_data[i]); 

        printf("Input: [%lf, %lf], Prediction: %lf, Weight:%lf\n", 
         
               training_data[i][0], training_data[i][1], prediction, weights[i]); 

    } 

    printf("bias:%lf\n",bias);
    
    printf("\n\t *** Neural network based on GAP8 ***\n");
    
    return pmsis_kickoff((void *)helloworld);
}

