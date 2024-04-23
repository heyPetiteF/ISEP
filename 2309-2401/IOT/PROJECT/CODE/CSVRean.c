#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ROWS 100
#define NUM_COLUMNS 7 // 6 data columns + 1 for "angle value"

int main() {
    FILE *file;
    char line[1024]; // Buffer to store each line read from the file
    double data[MAX_ROWS][NUM_COLUMNS];
    int rows = 0;

    // Open CSV file
    file = fopen("flexSensorData.csv", "r");
    if (file == NULL) {
        printf("无法打开文件！\n");
        return 1;
    }

    // Read and parse each line of the CSV file
    while (fgets(line, sizeof(line), file) != NULL && rows < MAX_ROWS) {
        char *token;
        int col = 0;

        // Tokenize the line based on the delimiter ";"
        token = strtok(line, ";");

        // Process each token (data element) in the line
        while (token != NULL && col < NUM_COLUMNS) {
            // Convert token to double and store it in the data array
            data[rows][col] = atof(token);
            token = strtok(NULL, ";");
            col++;
        }

        rows++;
    }

    fclose(file);

    // Display the read data
    printf("读取的数据：\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < NUM_COLUMNS; j++) {
            printf("%.2lf ", data[i][j]);
        }
        printf("\n");
    }

    return 0;
}

