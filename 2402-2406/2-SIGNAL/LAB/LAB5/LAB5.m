%% Read the image
B = imread('C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/LAB5/fichier2.bmp', 'bmp');
B = 255 * B;
figure, imshow(B, []);
colormap(gray);
title('Original Image');

%% Pixels shifted calculation
% Initialize the array storing the shift
offsets = zeros(size(B, 1), 1);

% Calculate the offset of each row relative to the adjacent previous row
for i = 2:size(B, 1)
    previous_row = double(B(i-1, :));
    current_row = double(B(i, :));

    % Use the xcorr function to calculate the cross-correlation between two adjacent rows
    [correlation, lags] = xcorr(previous_row, current_row);

    % Find the offset corresponding to the maximum correlation value
    [~, max_index] = max(correlation);
    offsets(i) = lags(max_index);
end

% Accumulate offsets so that all rows are aligned relative to the middle row
mid_index = floor(size(B, 1) / 2);
cumulative_offsets = cumsum(offsets);
shift_to_middle = cumulative_offsets(mid_index);

%% Generate correct image
% Create a new image matrix
corrected_B = zeros(size(B), 'like', B);

% Adjust the position of each row so that it is aligned relative to the middle row
for i = 1:size(B, 1)
    shift_amount = cumulative_offsets(i) - shift_to_middle;
    corrected_B(i, :) = circshift(B(i, :), [0, shift_amount]);
end

% Convert image data to 8-bit unsigned integer type
corrected_B = uint8(corrected_B);

% Display the recovered image
figure, imshow(corrected_B, []);
colormap(gray);
title('Correct Image');
