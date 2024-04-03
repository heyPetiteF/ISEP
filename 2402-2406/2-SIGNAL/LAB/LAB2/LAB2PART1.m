% Get the Info
[sig, Fs] = audioread('C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/Don_Giovanni_1.wav');
fprintf('The frequency Sample is: %d \n', Fs);

% FFT
fft_sig = fft(sig);

% Calculate Info
n = length(sig); 
f = (0:n-1)*(Fs/n); 
magnitude = abs(fft_sig); 

% One-sided spectrum
half_n = ceil(n/2);
f = f(1:half_n);
magnitude = magnitude(1:half_n);

% Draw the Spectrum - Original
figure(1);
plot(f, magnitude);
title('Spectrum of Don-Giovanni-1.wav');
xlabel('Frequency(Hz)');
ylabel('Amplitude');

% Using findpeaks() to find the peak points
[peaks, locs] = findpeaks(magnitude, f, 'SortStr', 'descend', 'NPeaks', 2);
hold on;
plot(locs, peaks, 'r*', 'MarkerSize', 10);
hold off;
fprintf('The first noise frequency is: %.2f Hz\n', locs(1));
fprintf('The second noise frequency is: %.2f Hz\n', locs(2));

% Draw the semilogx - Original
figure(2);
semilogx(f, 20*log10(magnitude));
title('Single-Sided Power Spectrum of Signal');
xlabel('Frequency (Hz)');
ylabel('Power/Frequency (dB/Hz)');

% Filter parameters
Q = 35;

% Design the notch filters using fdesign.notch and design functions
d1 = fdesign.notch('N,F0,Q', 2, locs(1), Q, Fs);
Hd1 = design(d1, 'butter');
[bn1, an1] = tf(Hd1);

d2 = fdesign.notch('N,F0,Q', 2, locs(2), Q, Fs);
Hd2 = design(d2, 'butter');
[bn2, an2] = tf(Hd2);

% Apply the notch filters
filtered_signal1 = filter(bn1, an1, sig);
filtered_signal = filter(bn2, an2, filtered_signal1);

% FFT of the filtered signal
fft_filtered_sig = fft(filtered_signal);
magnitude_filtered = abs(fft_filtered_sig(1:half_n));

% Draw the Spectrum - After
figure(3);
plot(f, magnitude_filtered);
title('Spectrum of Don-Giovanni-1.wav');
xlabel('Frequency(Hz)');
ylabel('Amplitude');


% Draw the semilogx - After
figure(4);
semilogx(f, 20*log10(magnitude_filtered));
title('Single-Sided Power Spectrum of Filtered Signal');
xlabel('Frequency (Hz)');
ylabel('Power/Frequency (dB/Hz)');

% Save the filtered signal
%audiowrite('Filtered_Don_Giovanni_1.wav', filtered_signal, Fs);

% Optional: Listen to the original and filtered signal
% sound(filtered_signal, Fs);
