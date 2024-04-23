#include "pmsis.h"
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define INPUT_SIZE 6
#define HIDDEN_LAYER_SIZE 10
#define OUTPUT_SIZE 1
#define LEARNING_RATE 0.01
#define EPOCHS 10000
#define RAND_MAX 32767
#define MAX_ROWS 60

double weights_input_hidden[INPUT_SIZE][HIDDEN_LAYER_SIZE];
double weights_hidden_output[HIDDEN_LAYER_SIZE];
double bias;

unsigned int seed = 42;

unsigned int simple_rand() {
    seed = (seed * 1103515245 + 12345) % RAND_MAX;
    return seed;
}

double activation(double x) {
    return (x > 0) ? x : 0.0;  // ReLU
}

void initialize() {
    for (int i = 0; i < INPUT_SIZE; i++) {
        for (int j = 0; j < HIDDEN_LAYER_SIZE; j++) {
            weights_input_hidden[i][j] = ((double)simple_rand() / RAND_MAX) * 0.1 - 0.05;
        }
    }

    for (int i = 0; i < HIDDEN_LAYER_SIZE; i++) {
        weights_hidden_output[i] = ((double)simple_rand() / RAND_MAX) * 0.1 - 0.05;
    }

    bias = ((double)simple_rand() / RAND_MAX) * 0.1 - 0.05;
}

double predict(double inputs[]) {
    double hidden[HIDDEN_LAYER_SIZE];

    for (int i = 0; i < HIDDEN_LAYER_SIZE; i++) {
        hidden[i] = 0;
        for (int j = 0; j < INPUT_SIZE; j++) {
            hidden[i] += weights_input_hidden[j][i] * inputs[j];
        }
        hidden[i] = activation(hidden[i]);
    }

    double output = 0;
    for (int i = 0; i < HIDDEN_LAYER_SIZE; i++) {
        output += weights_hidden_output[i] * hidden[i];
    }
    output += bias;
    return output;  // For regression, no activation is applied
}

void train(double inputs[], double target) {
    double prediction = predict(inputs);
    double error = target - prediction;

    for (int i = 0; i < HIDDEN_LAYER_SIZE; i++) {
        for (int j = 0; j < INPUT_SIZE; j++) {
            weights_input_hidden[j][i] += LEARNING_RATE * error * inputs[j];
        }
        weights_hidden_output[i] += LEARNING_RATE * error;
    }

    bias += LEARNING_RATE * error;
}

void cluster_helloworld(void *arg) {

    uint32_t core_id = pi_core_id(), cluster_id = pi_cluster_id();

    printf("[%d %d] flexSensorData HIDDEN_LAYER Test\n", cluster_id, core_id);

}

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
    printf("[%d %d] flexSensorData HIDDEN_LAYER Test\n", cluster_id, core_id);

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
    double training_data[MAX_ROWS][INPUT_SIZE] = {
       {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
        {0}, {20}, {40}, {60}, {80},{90},
    };
    double targets[MAX_ROWS] = {
        1.96,1.83,1.74,1.60,1.55,1.41,

	1.95,1.85,1.75,1.63,1.53,1.38,

	1.95,1.85,1.75,1.63,1.53,1.40,

	1.94,1.88,1.81,1.61,1.50,1.41,

	1.94,1.86,1.78,1.68,1.53,1.40,

	1.94,1.87,1.74,1.66,1.54,1.37,

	1.93,1.83,1.78,1.66,1.53,1.39,

	1.96,1.85,1.75,1.66,1.57,1.40,

	1.94,1.85,1.77,1.64,1.55,1.41,

	1.94,1.86,1.74,1.63,1.54,1.40,

	1.93,1.86,1.73,1.60,1.55,1.40,

	1.93,1.88,1.77,1.60,1.52,1.38,

	1.94,1.85,1.75,1.62,1.51,1.39,

	1.94,1.87,1.77,1.66,1.55,1.44,

	1.95,1.88,1.77,1.64,1.57,1.44,

	1.95,1.84,1.77,1.65,1.57,1.40,

	1.95,1.86,1.75,1.63,1.56,1.41,

	1.94,1.87,1.81,1.65,1.55,1.39,

	1.93,1.84,1.81,1.60,1.55,1.39,

	1.93,1.90,1.77,1.64,1.55,1.40,

	1.94,1.90,1.74,1.63,1.53,1.39,

	1.95,1.88,1.79,1.62,1.55,1.44,

	1.95,1.88,1.73,1.64,1.54,1.40,

	1.95,1.89,1.76,1.62,1.55,1.43,

	1.94,1.89,1.78,1.62,1.53,1.41,

	1.94,1.86,1.77,1.60,1.55,1.43,

	1.94,1.91,1.82,1.59,1.53,1.47,

	1.93,1.89,1.79,1.59,1.53,1.43,

	1.94,1.92,1.77,1.63,1.52,1.38,

	1.95,1.87,1.78,1.62,1.52,1.44,

	1.95,1.87,1.77,1.61,1.57,1.40,

	1.93,1.90,1.77,1.60,1.55,1.39,

	1.94,1.86,1.74,1.63,1.56,1.39,

	1.94,1.84,1.78,1.65,1.56,1.41,

	1.94,1.89,1.78,1.59,1.51,1.41,

	1.94,1.88,1.78,1.61,1.55,1.40,

	1.96,1.87,1.79,1.65,1.57,1.37,

	1.95,1.89,1.80,1.64,1.57,1.44,

	1.96,1.89,1.76,1.60,1.56,1.43,

	1.94,1.86,1.75,1.63,1.55,1.44,

	1.94,1.92,1.82,1.61,1.57,1.39,

	1.94,1.84,1.79,1.59,1.57,1.43,

	1.94,1.87,1.76,1.63,1.55,1.47,

	1.94,1.85,1.78,1.60,1.57,1.42,

	1.95,1.85,1.79,1.60,1.59,1.44,

	1.95,1.82,1.77,1.60,1.59,1.48,

	1.96,1.80,1.75,1.60,1.55,1.47,

	1.94,1.79,1.74,1.59,1.55,1.43,

	1.95,1.81,1.78,1.60,1.56,1.43,

	1.94,1.82,1.78,1.59,1.56,1.42,

	1.94,1.86,1.78,1.58,1.58,1.44,

	1.94,1.85,1.78,1.61,1.56,1.43,

	1.94,1.82,1.78,1.62,1.59,1.44,

	1.96,1.80,1.76,1.61,1.55,1.44,

	1.96,1.81,1.82,1.59,1.55,1.49,

	1.95,1.82,1.79,1.58,1.57,1.46,

	1.94,1.79,1.81,1.61,1.56,1.44,

	1.94,1.84,1.81,1.59,1.54,1.43,

	1.94,1.84,1.78,1.59,1.54,1.44,
    };

    int rows = sizeof(training_data) / sizeof(training_data[0]);
    initialize();

    for (int epoch = 0; epoch < EPOCHS; epoch++) {
        for (int i = 0; i < rows; i++) {
            train(training_data[i], targets[i]);
        }
    }

double prediction;

    // Output the results
    for (int i = 0; i < rows; i++) {
        //double prediction = predict(training_data[i]);
        prediction = predict(training_data[i]);
        //printf("Input: [%lf], Prediction: %lf\n", training_data[i][0], prediction);
    }

   for (int i = 0; i < rows; i++) {
        double prediction = predict(training_data[i]);
        //printf("Input: [%lf], Prediction: %lf, Weight: %lf\n", training_data[i][0], prediction, weights_hidden_output[0]);
    }
  
    printf("\n\t*** Neural Network Parameters ***\n");
    
    printf("\n>>>Define:\n");
    
    //printf("Input Size: %d\n", INPUT_SIZE);
    //printf("Output Size: %d\n", OUTPUT_SIZE);
    printf("Learning Rate: %lf\n", LEARNING_RATE);
    printf("Epochs: %d\n", EPOCHS);
    printf("HIDDEN_LAYER_SIZE: %d\n", HIDDEN_LAYER_SIZE);
    
    printf("\n>>>Neural network parameters:\n");
    
    printf("Weight: %lf\n", weights_hidden_output[0]);
    printf("Prediction: %lf\n", prediction);
    printf("Bias: %lf\n", bias);
    
    printf("\n\t***  flexSensorData HIDDEN_LAYER Test  ***\n");
    
    return pmsis_kickoff((void *)helloworld);
}

