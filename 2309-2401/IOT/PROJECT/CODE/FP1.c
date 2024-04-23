#include <stdio.h> 

#include <stdlib.h> 

#include <math.h> 

// define neural network paramaters 

#define INPUT_SIZE 2 

#define OUTPUT_SIZE 1 

#define LEARNING_RATE 0.01 

#define EPOCHS 10000 

// define ReLU activated function） 

double activation(double x) { 

    return (x > 0) ? x: 0.0; 

} 

// define neural network weights and bias 

double weights[INPUT_SIZE]; 

double bias; 

// initialize NN paramaters 

void initialize() { 

    for (int i = 0; i < INPUT_SIZE; i++) { 

        weights[i] = ((double)rand() / RAND_MAX) * 2 - 1;// initialize random weights 

    } 

    bias = ((double)rand() / RAND_MAX) * 2 - 1; // initialize random bias  

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

int main() { 

    printf("\n\t *** Neural Network Test *** \n" );

    // Initialize the neural network 

    initialize(); 

    // prepare training data 

    /*This is just a example, you can add your own train data here*/ 

    double training_data[][INPUT_SIZE] = {{0.1, 0.12}, {1.1, 0.9}, {2.1,1.98}, {2.89, 3.2}}; 

    double targets[] = {0, 1, 2, 3}; 

    /* add your test_data here */ 

    // Train a neural network 

    for (int epoch = 0; epoch < EPOCHS; epoch++) { 

        for (int i = 0; i < sizeof(training_data) / sizeof(training_data[0]); i++) { 

            train(training_data[i], targets[i]); 

        } 

    } 

    // Test neural network 

    /*Here you should use your test data added before*/ 

    for (int i = 0; i < sizeof(training_data) / sizeof(training_data[0]); i++) { 

        double prediction = predict(training_data[i]); 

        printf("Input: [%lf, %lf], Target: %lf, Prediction: %lf\n",  

               training_data[i][0], training_data[i][1], targets[i], prediction); 

    } 

    return 0; 

} 
