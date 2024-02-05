# Import data
CCPP.data <- read.delim("C:/Users/16273/OneDrive/桌面/CCPP-data.txt")
# View data
View(CCPP.data)
# Data dimensions
dim(CCPP.data)
# Missing value check
sum(is.na(CCPP.data))
any(is.na(CCPP.data))
# Descriptive statistics
summary(CCPP.data)
# Boxplot
boxplot(CCPP.data$AT, main="Boxplot for Ambient Temperature (AT)")
boxplot(CCPP.data$V, main="Boxplot for Exhaust Vacuum (V)")
boxplot(CCPP.data$AP, main="Boxplot for Ambient Pressure (AP)")
boxplot(CCPP.data$RH, main="Boxplot for Relative Humidity (RH)")
boxplot(CCPP.data$EP, main="Boxplot for Electrical Energy Output (EP)")
# Scatter plot
plot(CCPP.data$AT, CCPP.data$EP, main="Ambient Temperature (AT) vs Electrical Energy Output (EP)", xlab="Ambient Temperature", ylab="Energy Output")
plot(CCPP.data$V, CCPP.data$EP, main="Exhaust Vacuum (V) vs Electrical Energy Output (EP)", xlab="Exhaust Vacuum", ylab="Energy Output")
plot(CCPP.data$AP, CCPP.data$EP, main="Ambient Pressure (AP) vs Electrical Energy Output (EP)", xlab="Ambient Pressure", ylab="Energy Output")
plot(CCPP.data$RH, CCPP.data$EP, main="Relative Humidity (RH) vs Electrical Energy Output (EP)", xlab="Relative Humidity", ylab="Energy Output")
# Correlation coefficient
correlation_matrix <- cor(CCPP.data)
print(correlation_matrix)
# Calculate the variance of each variable
variances <- apply(CCPP.data, 2, var)
# standardization
CCPP.data.scaled <- scale(CCPP.data)
# Print variance & Standardized variable value
print(variances)
print(head(CCPP.data.scaled))
# PCA
pca.result <- prcomp(CCPP.data.scaled, scale = FALSE)
# Loading vectors of the first two principal components
loadings <- pca.result$rotation[, 1:2]
# Print PCA & first two principal components value
print(pca.result)
print(loadings)
# PVE
pve <- pca.result$sdev^2 / sum(pca.result$sdev^2)
cumulative.pve <- cumsum(pve)
# Print PVE value
print(pve)
print(cumulative.pve)
# Plot-PVE
plot(pve, xlab="Principal Component", ylab="Proportion of Variance Explained", type='o')
plot(cumulative.pve, xlab="Principal Component", ylab="Cumulative Proportion of Variance Explained", type='o')
# Biplots
biplot(pca.result, scale = 0)