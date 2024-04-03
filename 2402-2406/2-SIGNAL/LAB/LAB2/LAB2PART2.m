% Get the Info
[sig, Fs] = audioread('C:/Users/16273/GitHub/ISEP-Documents/2402-2406/2-SIGNAL/LAB/Don_Giovanni_2.wav');
fprintf('The frequency Sample is: %d \n', Fs);

% Filter order N
N_values = [3,11,31];

for N = N_values
    % Define FIR filter coefficient
    b = ones(1, N) / N;
    % For FIR filters, the denominator coefficient is 1
    an = 1;

    % Calculate and draw impulse response
    figure;
    impz(b, an);
    title(['Impulse Response - Filter Order N = ', num2str(N)]);

    % Calculate frequency response
    [H, w] = freqz(b, an, 'half', 1024);
    % fprintf('The frequency response is: %.2f \n', w);

    % Plot magnitude response
    figure;
    plot(w, 20 * log10(abs(H)));
    title(['Magnitude Response - Filter Order N =', num2str(N)]);
    xlabel('Frequency (Hz)');
    ylabel('Magnitude(dB)');

    % Plot phase response
    figure;
    plot(w, unwrap(angle(H)));
    title(['Phase Response - Filter Order N=', num2str(N)]);
    xlabel('Frequency (Hz)');
    ylabel('Phase (radians)');

end