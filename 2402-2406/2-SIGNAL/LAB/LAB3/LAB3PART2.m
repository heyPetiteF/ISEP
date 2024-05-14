% Get the Info
[sig, Fs] = audioread('C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/LAB3/Pa11.wav'); 

% Perform an FFT on the signal and generate a frequency vector
N = length(sig);    
Y = fft(sig);
F = linspace(0, Fs, N);

% Spectrogram of the original signal
figure;
plot(F, abs(Y));
title('Spectrum of Original Audio Signal');
xlabel('Frequency (Hz)');
ylabel('Magnitude');
grid on;
hold on;
for k = 1:7
    xline(k * Fs / 8, 'r--');
end
hold off;

% Apply mapping rules for exchange
% Generate index mapping array swapIndices for swapping frequency components
swapIndices = 1:N;
for k = 2:(N/2)
    % Exclude the Nyquist frequency point, which is at position N/2+1
    if k ~= N/4+1 
        swapIndices(k) = N-k+2;
        swapIndices(N-k+2) = k;
    end
end
Y_swapped = Y(swapIndices);

% Apply IFFT to obtain the corrected signal
correctedSig = real(ifft(Y_swapped));

% Calculate the FFT of the corrected signal
Y_corrected = fft(correctedSig);

% Spectrogram of the corrected signal
figure;
plot(F, abs(Y_corrected));
title('Spectrum of Corrected Audio Signal');
xlabel('Frequency (Hz)');
ylabel('Magnitude');
grid on;
hold on;
for k = 1:7
    xline(k * Fs / 8, 'r--');
end
hold off;

% Since the difference cannot be directly seen by observing the two images
% the following operations are performed:
% Calculate the difference between the spectra of two signals
magnitude_diff = abs(Y) - abs(Y_corrected);

% Spectral difference plot
figure;
plot(F, magnitude_diff);
title('Magnitude Difference Between Two Spectrum');
xlabel('Frequency (Hz)');
ylabel('Magnitude Difference');
grid on;
hold on;
for k = 1:7
    xline(k * Fs / 8, 'r--');
end
hold off;
