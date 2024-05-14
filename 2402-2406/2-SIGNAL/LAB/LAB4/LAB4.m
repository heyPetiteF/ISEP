%% Proceed as follows:
% 1. In the part of "Value Setting", Lower the two parameters (can be set to zero), 
%    then run the code and get four images. Observe image 2 (orange).
% 2. For the amplitude range of the smaller amplitude area (middle of each high amplitude) in Figure 2, 
%    the approximate peak value is the value of [threshold1].
% 3. For the amplitude range of the medium amplitude area (generally both sides) in Figure 2, 
%    the approximate peak value is the value of [threshold2].
% 4. Close the image and re-run the code to observe the new images.
% 5. If the amplitude between the high amplitude in Figure 2 (orange) is 0, 
%       it means that the noise filtering is successful. 
%    Otherwise, increase the value of [threshold1] appropriately.
% 6. The amplitude on both sides of Figure 3 (red) is 0, 
%       it means that the dial tone filtering is successful.
%    Otherwise increase the value of [threshold2] appropriately.
% 7. If significant changes occur in high-amplitude areas, the value needs to be appropriately reduced.
% 8. Repeat the above steps until only clear high-amplitude information is retained in Figure 3 or Figure 4, 
%    and the green box in Figure 4 accurately includes every high-amplitude information.
% 9. The dialing information will be displayed in the Command Window.
% Note: You can only adjust one of the parameters to the peak size of the mid-amplitude range, and set the other to 0. 
%       The purpose of setting it twice is to confirm the filtering effect during the process.

%% Value Settings
% Set the amplitude value 1 for the first smoothing process (remove background noise)
threshold1 = 0.4;

% Set the amplitude value to 1 for smoothing again (remove dial tone)
threshold2 = 1.0;


%% Read audio files
    %% No.0
    % filename = 'C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/LAB4/0123456789.wav';
    % The audio '0123456789.wav' dial is: 0123456789
    % Set threshold1 = 0.2 & threshold2 = 0.6;
    
    %% No.1
    % filename = 'C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/LAB4/numero1.wav';
    % The audio 'numero1.wav' dial is: 0145841132
    % Set threshold1 = 0.1 & threshold2 = 0.2;
    
    %% No.2
    % filename = 'C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/LAB4/numero2.wav';
    % The audio 'numero2.wav' dial is: 0145236970
    % Set threshold1 = 0.5 & threshold2 = 1.0;
    
    %% No.3
    % filename = 'C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/LAB4/numero3.wav';
    % The audio 'numero3.wav' dial is: 0149545262
    % Set threshold1 = 0.2 & threshold2 = 0.6;
    %% No.4
    % filename = 'C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/LAB4/numero4.wav';
    % The audio 'numero4.wav' dial is: 0836687070
    % Set threshold1 = 0.4 & threshold2 = 1.0;

[y, Fs] = audioread(filename); 
% fprintf('The sampling frequency is: %d Hz\n', Fs);

%% Plot original signal
t = (0:length(y)-1)/Fs;
figure;
plot(t, y);
title('Original Tone (time domain)');
xlabel('Time (seconds)');
ylabel('Amplitude');

%% Design a high-pass filter with a cutoff frequency of 650 Hz
    % Because the lowest frequency of key tone is 697 (1.5% error tolerance rate)
    cutoff_freq = 650;
    [b, a] = butter(10, cutoff_freq/(Fs/2), 'high');
    
    % Apply a high-pass filter to the audio signal
    y_filtered = filter(b, a, y);
    y_filtered_smooth1 = y_filtered;
    y_filtered_smooth1(abs(y_filtered) < threshold1) = 0;
    
    % Plot the filtered and smoothed signal
    figure;
    plot(t, y_filtered_smooth1, 'Color', [1, 0.5, 0]); % set to orange
    title('Filtered & Smoothed Tone - Background Noise Removal (time domain)');
    xlabel('Time (seconds)');
    ylabel('Amplitude');

%% Smooth the filtered signal to remove background noise
    y_filtered_smooth = y_filtered_smooth1;
    y_filtered_smooth(abs(y_filtered_smooth1) < threshold2) = 0;
    
    % Plot the filtered and smoothed signal
    figure;
    plot(t, y_filtered_smooth, 'Color', [1, 0, 0]); 
    title('Filtered & Smoothed Tone - Dial Tone Removal (time domain)');
    xlabel('Time (seconds)');
    ylabel('Amplitude');

%% DTMF frequency and key mapping
dtmf_freqs = [697, 770, 852, 941, 1209, 1336, 1477, 1633];
dtmf_keys = [
    '1', '2', '3', 'A';
    '4', '5', '6', 'B';
    '7', '8', '9', 'C';
    '*', '0', '#', 'D'
];
low_freqs = [697, 770, 852, 941];
high_freqs = [1209, 1336, 1477, 1633];
freq_tolerance = 0.015; % fault tolerance

%% Audio Segmentation
    % Defines the threshold for silent segments (amplitude is 0 for 80ms continuously)
    silent_duration_threshold = 0.08;
    silent_sample_threshold = round(silent_duration_threshold * Fs);
    
    % Traverse the signal to detect valid sound segments
    effective_tones = [];
    start_idx = 1;
    in_silent = false;
    silent_start_idx = -1;
    
    for i = 1:length(y_filtered_smooth)
        if abs(y_filtered_smooth(i)) == 0
            if ~in_silent
                silent_start_idx = i;
            end
            in_silent = true;
        else
            if in_silent && (i - silent_start_idx >= silent_sample_threshold)
                if start_idx < silent_start_idx
                    effective_tones = [effective_tones; start_idx, silent_start_idx - 1];
                end
                start_idx = i;
            end
            in_silent = false;
        end
    end
    
    % Check: if the last segment is a valid sound segment, add it to the list
    if ~in_silent && start_idx < length(y_filtered_smooth)
        effective_tones = [effective_tones; start_idx, length(y_filtered_smooth)];
    elseif in_silent && (length(y_filtered_smooth) - silent_start_idx >= silent_sample_threshold)
        effective_tones = [effective_tones; start_idx, silent_start_idx - 1];
    end
    
    % Print the dialed number (number digits)
    % fprintf('Total number of dialed digits: %d\n', size(effective_tones, 1));
    fprintf('The number dialed is: ');

%% Obtain the main frequency information of each valid sound segment and compare it
    for i = 1:size(effective_tones, 1)
        segment = y_filtered_smooth(effective_tones(i, 1):effective_tones(i, 2));
        if isempty(segment)
            continue;
        end
        Y_segment = fft(segment);
        L_segment = length(segment);
        P2_segment = abs(Y_segment / L_segment);
        P1_segment = P2_segment(1:floor(L_segment/2)+1); % Make sure to use integer indexing
        P1_segment(2:end-1) = 2 * P1_segment(2:end-1);
        f_segment = Fs * (0:(floor(L_segment/2))) / L_segment;
        
        % Find the two main frequency components
        [sorted_amplitudes, indices] = sort(P1_segment, 'descend');
        main_freqs = sort(f_segment(indices(1:2))); % Sort by frequency
        
        % Find the closest DTMF frequency
        [~, low_idx] = min(abs(low_freqs - main_freqs(1)));
        [~, high_idx] = min(abs(high_freqs - main_freqs(2)));
        
        % Make sure the frequency is within the allowable error range
        if abs(low_freqs(low_idx) - main_freqs(1)) / low_freqs(low_idx) <= freq_tolerance && ...
           abs(high_freqs(high_idx) - main_freqs(2)) / high_freqs(high_idx) <= freq_tolerance
            % Output the corresponding button
            detected_key = dtmf_keys(low_idx, high_idx);
            fprintf('%s', detected_key);
        else
            fprintf('The NO. %d key cannot be recognized\n', i);
        end
    end
    
    fprintf('\n ');
    
%% Plot filtered and smoothed signals and valid sound clips
figure;
plot(t, y_filtered_smooth, 'Color', [1, 0, 0]); 
hold on;
for i = 1:size(effective_tones, 1)
    start_time = (effective_tones(i, 1) - 1) / Fs;
    end_time = (effective_tones(i, 2) - 1) / Fs;
    fill([start_time, end_time, end_time, start_time], [min(y_filtered_smooth), min(y_filtered_smooth), max(y_filtered_smooth), max(y_filtered_smooth)], 'g', 'FaceAlpha', 0.3, 'EdgeColor', 'none');
end
title('Effective Sound Area (time domain)');
xlabel('Time(secoonds)');
ylabel('Amplitude');
hold off;
