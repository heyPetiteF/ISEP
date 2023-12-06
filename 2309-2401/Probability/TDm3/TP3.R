# 1. Quantitative variable

> cats <- read.csv("C:/Users/16273/GitHub/ISEP-Documents/2309-2401/Probability/TDm3/cats.txt", sep="")

# Exercise 1
> names(cats)
[1] "Sex" "Bwt" "Hwt"
> names(cats)
[1] "Sex" "Bwt" "Hwt"
> paste("Number of variables:", ncol(cats))
[1] "Number of variables: 3"
> paste("Number of observations:", nrow(cats))
[1] "Number of observations: 144"
> head(cats, 10)
   Sex Bwt Hwt
1    F 2.0 7.0
2    F 2.0 7.4
3    F 2.0 9.5
4    F 2.1 7.2
5    F 2.1 7.3
6    F 2.1 7.6
7    F 2.1 8.1
8    F 2.1 8.2
9    F 2.1 8.3
10   F 2.1 8.5
> cats[6, c("Sex", "Hwt")]
  Sex Hwt
6   F 7.6
> Bwt
错误: 找不到对象'Bwt'
> attach(cats)
> Bwt
  [1] 2.0 2.0 2.0 2.1 2.1 2.1 2.1 2.1 2.1
 [10] 2.1 2.1 2.1 2.2 2.2 2.2 2.2 2.2 2.2
 [19] 2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3
 [28] 2.3 2.3 2.3 2.4 2.4 2.4 2.4 2.5 2.5
 [37] 2.6 2.6 2.6 2.7 2.7 2.7 2.9 2.9 2.9
 [46] 3.0 3.0 2.0 2.0 2.1 2.2 2.2 2.2 2.2
 [55] 2.2 2.2 2.2 2.2 2.3 2.4 2.4 2.4 2.4
 [64] 2.4 2.5 2.5 2.5 2.5 2.5 2.5 2.5 2.5
 [73] 2.6 2.6 2.6 2.6 2.6 2.6 2.7 2.7 2.7
 [82] 2.7 2.7 2.7 2.7 2.7 2.7 2.8 2.8 2.8
 [91] 2.8 2.8 2.8 2.8 2.9 2.9 2.9 2.9 2.9
[100] 3.0 3.0 3.0 3.0 3.0 3.0 3.0 3.0 3.0
[109] 3.1 3.1 3.1 3.1 3.1 3.1 3.2 3.2 3.2
[118] 3.2 3.2 3.2 3.3 3.3 3.3 3.3 3.3 3.4
[127] 3.4 3.4 3.4 3.4 3.5 3.5 3.5 3.5 3.5
[136] 3.6 3.6 3.6 3.6 3.7 3.8 3.8 3.9 3.9
> mean_Bwt <- mean(Bwt)
> median_Bwt <- quantile(Bwt, 0.5)
> quartile_1 <- quantile(Bwt, 0.25)
> quartile_2 <- quantile(Bwt, 0.5)
> quartile_3 <- quantile(Bwt, 0.75)
> variance_Bwt <- var(Bwt)
> std_dev_Bwt <- sd(Bwt)
> range_Bwt <- diff(range(Bwt))
> IQR_Bwt <- IQR(Bwt)
> summary(cats)
     Sex                 Bwt       
 Length:144         Min.   :2.000  
 Class :character   1st Qu.:2.300  
 Mode  :character   Median :2.700  
                    Mean   :2.724  
                    3rd Qu.:3.025  
                    Max.   :3.900  
      Hwt       
 Min.   : 6.30  
 1st Qu.: 8.95  
 Median :10.10  
 Mean   :10.63  
 3rd Qu.:12.12  
 Max.   :20.50  

 #Exercise 3
 > boxplot(Bwt, Hwt, names = c("Body Weight", "Heart Weight"), 
+         main = "Boxplots of Body Weight and Heart Weight",
+         ylab = "Weight")
> summary(cats[c("Bwt", "Hwt")])
      Bwt             Hwt       
 Min.   :2.000   Min.   : 6.30  
 1st Qu.:2.300   1st Qu.: 8.95  
 Median :2.700   Median :10.10  
 Mean   :2.724   Mean   :10.63  
 3rd Qu.:3.025   3rd Qu.:12.12  
 Max.   :3.900   Max.   :20.50  

# Exercise 4

> boxplot(Bwt, Hwt, names = c("Body Weight", "Heart Weight"), 
+         main = "Boxplots of Body Weight and Heart Weight",
+         ylab = "Weight")
> summary(cats[c("Bwt", "Hwt")])
      Bwt             Hwt       
 Min.   :2.000   Min.   : 6.30  
 1st Qu.:2.300   1st Qu.: 8.95  
 Median :2.700   Median :10.10  
 Mean   :2.724   Mean   :10.63  
 3rd Qu.:3.025   3rd Qu.:12.12  
 Max.   :3.900   Max.   :20.50  
> hist(Bwt, breaks = 2, main = "Histogram of Cat Weight (2 classes)", xlab = "Weight")
> hist(Bwt, breaks = 20, main = "Histogram of Cat Weight (20 classes)", xlab = "Weight")
> hist(Bwt, breaks = 200, main = "Histogram of Cat Weight (200 classes)", xlab = "Weight")
> hist(Bwt, breaks = 2000, main = "Histogram of Cat Weight (2000 classes)", xlab = "Weight")
> histo <- hist(Bwt, breaks = 4, plot = FALSE)
> freq_table <- data.frame(Intervals = histo$breaks[-length(histo$breaks)], 
+                          Frequency = histo$counts)
> freq_table
  Intervals Frequency
1       2.0        61
2       2.5        47
3       3.0        27
4       3.5         9

# 2. Qualitative variable

> cats <- read.csv("C:/Users/16273/GitHub/ISEP-Documents/2309-2401/Probability/TDm3/cats.txt", sep="")
>   View(cats)

> class(cats$Sex)
[1] "character"
> unique(cats$Sex)
[1] "F" "M"
> cats$Sex <- factor(cats$Sex)
> class(cats$Sex)
[1] "factor"
> unique(cats$Sex)
[1] F M
Levels: F M
> levels(cats$Sex)
[1] "F" "M"

# Exercise 5.(1)
> table(cats$Sex)

 F  M 
47 97 
> relative_freq <- prop.table(table(cats$Sex))
> relative_freq

        F         M 
0.3263889 0.6736111 

> freq_table <- table(cats$Sex)

# Exercise 5.(2)
> barplot(freq_table, main = "Sex Barplot", xlab = "Sex", ylab = "Frequency")
# Exercise 5.(3)
> pie(freq_table, labels = levels(cats$Sex), main = "Sex Distribution")

# Exercise 6
# Plot the boxplots of the weight of male and female cats and interpret the result
> boxplot(Bwt ~ Sex, data = cats, 
+         xlab = "Sex", ylab = "Bwt", 
+         main = "boxplots of the weight of male and female cats")

# Exercise 7
#  display the scatter plot of the variables (Bwt,Hwt)
> plot(cats$Bwt, cats$Hwt, 
+      xlab = "Body Weight", ylab = "Heart Weight", 
+      main = "Scatter Plot of Body Weight vs Heart Weight")

#  Calculate the sample covariance and correlation coefficient
> covariance <- cov(cats$Bwt, cats$Hwt)
> covariance
[1] 0.9501127
> correlation <- cor(cats$Bwt, cats$Hwt)
> correlation
[1] 0.8041274

# using different colors
> plot(cats$Bwt, cats$Hwt, col = ifelse(cats$Sex == "M", "blue", "red"), 
+      xlab = "Body Weight", ylab = "Heart Weight", 
+      main = "Scatter Plot of Body Weight vs Heart Weight by Sex")