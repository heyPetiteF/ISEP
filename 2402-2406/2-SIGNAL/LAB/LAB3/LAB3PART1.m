% Get the Info
[sig, Fs] = audioread('C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/LAB3/Pa11.wav');
%sound(sig, Fs);
fprintf('The frequency of Pa11.wav is: %d Hz\n', Fs);

% Calculate power spectral density
Y = fft(sig);
PSD = abs(Y).^2;
% Inverse Fourier Transform to obtain the autocorrelation function
R_fft = ifft(PSD);

% Use the Matlab function xcorr
[R_xcorr, lags] = xcorr(sig, 'biased');

% Plot two autocorrelation functions
figure;
subplot(2,1,1);
plot(real(R_fft));
title('Autocorrelation Functions - Inverse FFT');
subplot(2,1,2);
plot(lags, R_xcorr);
title('Autocorrelation Functions - xcorr');

% Separating positive delay values from autocorrelation functions
% Identify echo delay using only the positive lags
positiveLags = lags(lags >= 0);
positiveR_xcorr = R_xcorr(lags >= 0);

% Assume minLag as some small fraction of signal length to avoid direct signal peak
minLag = round(0.001 * length(sig));

% Using findpeaks() to find the peak points
% Find peaks with minimum peak height to avoid detecting noise as echo
[pks, locs] = findpeaks(positiveR_xcorr, 'MinPeakHeight', max(positiveR_xcorr)/4, 'MinPeakDistance', minLag);
fprintf('Number of peaks found: %d\n', length(pks));
    % From the result can see that there are 2 points

% Plot the peaks on the autocorrelation function
figure;
subplot(2,1,1);
plot(positiveLags, positiveR_xcorr);
title('Autocorrelation Function - xcorr (Positive Lags)');
hold on;
plot(positiveLags(locs), pks, 'r*', 'MarkerSize', 10); 
hold off;

% ===Design filters===
% For two echo points, the original audio can be expressed as: 
% x(n)=s(n)+α⋅s(n−D1)+β⋅s(n−D2)
% Filters : h(n)=δ(n)−α⋅δ(n−D1)−β⋅δ(n−D2)
% y(n)=x(n)∗h(n)

% Assume echo_delay as the location of the first peak detected
% The first peak after zero lag
echo_delay = positiveLags(locs(1)); 
second_echo_delay = positiveLags(locs(2));
fprintf('Estimated echo delay is: %d samples\n', echo_delay);

% Assume echo attenuation
% Since there are two peak points, two parameters are designed here
alpha = 0.6;  
beta = 0.3;

% Design a filter to remove a single echo: h(n)
filter_length = max(echo_delay, second_echo_delay) + 1;
filter = zeros(filter_length, 1);
% Direct signal component
filter(1) = 1; 
% Echo signal component
filter(echo_delay + 1) = -alpha;    
filter(second_echo_delay + 1) = -beta;

% Apply the filter to remove the echo
% Use 'full' for convolution
y_filtered = conv(sig, filter, 'full'); 
% Trim the filtered signal to the original length
y_filtered = y_filtered(1:length(sig)); 

% Play the signal after echo removal
sound(y_filtered, Fs); 

% Plot the original and filtered signals for comparison
figure; 
subplot(2, 1, 1); 
plot(sig);
title('Original Audio Signal');
xlabel('Sample Number');
ylabel('Amplitude');

subplot(2, 1, 2); 
plot(y_filtered);
title('Audio Signal After Echo Removal');
xlabel('Sample Number');
ylabel('Amplitude');
