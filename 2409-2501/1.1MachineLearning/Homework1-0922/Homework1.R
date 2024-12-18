# Homework1
# 1.1-3
#install.packages("MASS")
library(MASS)

# Quantitative variable X
X <- c(-1.6, -0.8, -1.8, 0.6, -0.7, -1.8, -0.5, -0.3, -0.4, -1.3, 2.5, 1.4, 0.4, -1.2, 2.1, 1.0, 1.0, 1.9, 1.8, 1.6)\
# Categorical variable Y
Y <- factor(c(rep("G", 10), rep("R", 10)))

#Posterior probability LDA
lda.fit <- lda(Y ~ X)
lda.pred <- predict(lda.fit)
lda.pred$posterior

print(lda.pred$posterior[, 1])
print(lda.pred$posterior[, 2])

#1.2
install.packages("pROC")
library(pROC)

# Extract the posterior probability of belonging to class R
posterior_R <- lda.pred$posterior[, 2]
actual_values <- Y

# Threshold Range [0.1,1]
thresholds <- seq(0.1, 1, by = 0.1)
# Calculate
predicted_values <- lapply(thresholds, function(threshold) {
  ifelse(posterior_R > threshold, "R", "G")
})

# the confusion matrix
confusion_matrices <- lapply(predicted_values, function(pred) {
  table(Predicted = pred, Actual = actual_values)
})

# sensitivity敏感性
sensitivity <- function(cm) {
  TP <- safe_get(cm, "R", "R")  
  FN <- safe_get(cm, "G", "R")  
  if ((TP + FN) == 0) return(NA) 
  TP / (TP + FN)
}

# specificity特异性
specificity <- function(cm) {
  TN <- safe_get(cm, "G", "G")  
  FP <- safe_get(cm, "R", "G") 
  if ((TN + FP) == 0) return(NA)  
  TN / (TN + FP)
}

# ROC
ROC.lda <- roc(actual_values, posterior_R, levels = c("R", "G"))
plot.roc(ROC.lda,print.auc =T,xlab="Specificity",col="red",axes=T)
