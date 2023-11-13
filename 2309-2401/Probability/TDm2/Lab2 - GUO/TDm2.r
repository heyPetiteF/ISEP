>TDm2
>
> # Exercise 1.1
> runif(5)
[1] 0.4740566 0.1404336 0.7982681
[4] 0.9442451 0.7614531
> rnorm(5)
[1] -0.7370111  0.5431928  0.4752964
[4] -0.2175778  0.3532408
> rnorm(5,10,1)
[1] 11.304921  8.678835  9.269298
[4]  8.488081 10.394986
> # Exercise 1.2
> data.exp = rexp(300, 4)
> # Exercise 1.3
> data.pois = rpois(300, 2)
> # Exercise 1.4
> density_at_0 = dnorm(0)
> # Exercise 1.5
> probability_5 = pnorm(0, mean = 0, sd = 5)
> # Exercise 1.6
> density1_0_4 = seq(0, 4, length.out = 100)
> density_0_4 = dexp(density1_0_4, rate = 4) 
> hist(data.exp)
> lines(density1_0_4, density_0_4, col = "red")
> # Exercise 1.7
> ranX = 0:10
> probabilities = dpois(ranX, lambda = 2)
> plot(table(data.pois)/300)

> # Exercise 2.1.1
> berTLC = function(n)
+ {
+     X=seq(0,n)
+     p=dbinom(X,n,0.5)
+     return(p)
+ }
> par(mfrow=c(2,5))
> plot(seq(0,1),c(0.5,0.5),ylim=c(0,0.6),xlim=c(0,2),type="l",xlab="X",
+      ylab="Freq",main="n=1",col="red")
> for(n in seq(2,10))
+ {
+     plot(seq(0,n),berTLC(n),ylim=c(0,0.6),xlim=c(0,n+1),type="l",xlab="X",
+          ylab="Freq",col="red", main=bquote(paste(,"n=",.(n))))
+ }
> # Exercise 2.1.2
> tclbernoulli <- function(N,p){
+     nb.echant <- 1000 
+     res <- rep(0,nb.echant) 
+     for (i in 1:nb.echant){
+         data <- rbinom(N,1,p) 
+         moy.emp <- mean(data) 
+         res[i] <- sqrt(N/(p*(1-p)))*(moy.emp-p) 
+     }
+     return(res)
+ }

> # Exercise 2.2
> s<-tclbernoulli(10,0.2)
> mean(abs(s)<1.96)  
[1] 0.967
> s<-tclbernoulli(100,0.2)
> mean(abs(s)<1.96)  
[1] 0.938
> s<-tclbernoulli(1000,0.2)
> mean(abs(s)<1.96)  
[1] 0.955

> # Exercise 2.3
> par(mfrow=c(1,3))
> 
> res <- tclbernoulli(10,.2) 
> fdr10 <- ecdf(res)
> plot.ecdf(res,main="FdR, N=10",cex=0.5)
> lines(sort(res),pnorm(sort(res)),col='red')
> 
> # N=100
> res_100 <- tclbernoulli(100, 0.2) 
> fdr_100 <- ecdf(res_100)
> plot.ecdf(res_100, main="FdR, N=100", cex=0.5)
> lines(sort(res_100), pnorm(sort(res_100)), col='red')

> # N=1000
> res_1000 <- tclbernoulli(1000, 0.2) 
> fdr_1000 <- ecdf(res_1000)
> plot.ecdf(res_1000, main="FdR, N=1000", cex=0.5)
> lines(sort(res_1000), pnorm(sort(res_1000)), col='red')
> 

> # Exercise 2.4

> # 定义 tclbernoulli 函数（在之前的交互中已提供）
> # 计算 N=10 时的经验累积分布函数和标准正态分布的理论累积分布函数
> res_10 <- tclbernoulli(10, 0.2)
> ecdf_10 <- ecdf(res_10)
> theoretical_cdf_10 <- pnorm(sort(res_10))
> 
> # 计算 N=100 时的经验累积分布函数和标准正态分布的理论累积分布函数
> res_100 <- tclbernoulli(100, 0.2)
> ecdf_100 <- ecdf(res_100)
> theoretical_cdf_100 <- pnorm(sort(res_100))
> 
> # 计算 N=1000 时的经验累积分布函数和标准正态分布的理论累积分布函数
> res_1000 <- tclbernoulli(1000, 0.2)
> ecdf_1000 <- ecdf(res_1000)
> theoretical_cdf_1000 <- pnorm(sort(res_1000))
> 
> # 绘制经验累积分布函数和理论累积分布函数的比较图
> par(mfrow=c(1,3))
> plot.ecdf(ecdf_10, main="Empirical vs Theoretical, N=10", col="blue", lwd=2)
> lines(sort(res_10), theoretical_cdf_10, col='red', lwd=2)
> 
> plot.ecdf(ecdf_100, main="Empirical vs Theoretical, N=100", col="blue", lwd=2)
> lines(sort(res_100), theoretical_cdf_100, col='red', lwd=2)
> 
> plot.ecdf(ecdf_1000, main="Empirical vs Theoretical, N=1000", col="blue", lwd=2)
> lines(sort(res_1000), theoretical_cdf_1000, col='red', lwd=2)
> 
> # Exercise 3.1
> par(mfrow=c(1,1))
> Nfin <- 5000
> X <- rexp(Nfin,2)
> Y <- cumsum(X)/1:Nfin
> plot(1:Nfin,Y,type = "l",ylim = c(0,1),xlab="n",ylab="empirical mean")
> for (i in 2:50){
+     X <- rexp(Nfin,2)
+     Y <- cumsum(X)/1:Nfin
+     lines(1:Nfin,Y,col = i)
+ }
> # Exercise 3.2
> lgnexpo <- function(N){
+     moy=rep(0,100)
+     for (i in 1:100){
+         moy[i]=mean(rexp(N,2))
+     }
+     return(moy)
+ }
> 
> boxplot(lgnexpo(100),lgnexpo(1000),lgnexpo(10000), names=c("100","1000","10000"),xlab='N: taille de l echantillon')
>
> # Exercise 3.2
> Nfin <- 5000
> X <- rcauchy(Nfin)
> Y <- cumsum(X)/1:Nfin
> plot(1:Nfin, Y, ylim=c(-50,50),type='l', xlab='n', ylab='moyenne empirique')
> for (i in 2:10){
+     X <- rcauchy(Nfin)
+     Y <- cumsum(X)/1:Nfin
+     lines(1:Nfin, Y, col=i)
+ }
> 
> lgncauchy <- function(N){
+     moy <- rep(0,100) 
+     for (i in 1:100){ 
+         moy[i] <- mean(rcauchy(N))
+     }
+     return(moy) 
+ }
> 
> boxplot(lgncauchy(100),lgncauchy(1000),lgncauchy(10000),outline=T,names=c("100","1000","10000"),xlab='N: taille de l echantillon')
> 
> boxplot(lgncauchy(100),lgncauchy(1000),lgncauchy(10000),outline=F,names=c("100","1000","10000"),xlab='N: taille de l echantillon')
>
> # Exercise 4.1
> lambda=8
> Bin10=rbinom(1000,10,lambda/10)
> # Do the same for N=10,20, 30 and 100
> lambda=8
> Bin20=rbinom(1000,20,lambda/20)
> lambda=8
> Bin30=rbinom(1000,30,lambda/30)
> lambda=8
> Bin100=rbinom(1000,100,lambda/100)
>
> # Exercise 4.2
> M=max(Bin10,Bin20,Bin30,Bin100)
> k=seq(0,M,by=1)
> dpois(k,lambda)
 [1] 0.0003354626 0.0026837010 0.0107348041 0.0286261442 0.0572522885
 [6] 0.0916036616 0.1221382155 0.1395865320 0.1395865320 0.1240769173
[11] 0.0992615338 0.0721902064 0.0481268043 0.0296164949 0.0169237114
[16] 0.0090259794 0.0045129897 0.0021237599 0.0009438933
>
> # Exercise 4.3
> par(mfrow=c(2,2))
> 
> plot(table(Bin10)/1000,main='N=10')
> points(k,dpois(k,lambda),col='red')
> # Do the same for N=10,20, 30 and 100
> 
> plot(table(Bin20)/1000,main='N=20')
> points(k,dpois(k,lambda),col='red')
>
> plot(table(Bin30)/1000,main='N=30')
> points(k,dpois(k,lambda),col='red')
> 
> plot(table(Bin100)/1000,main='N=100')
> points(k,dpois(k,lambda),col='red')
>
># Exercise 4.4
> plot(ecdf(Bin10),main='N=10')
> lines(k,ppois(k,lambda),type='s',col='red')
> # Do the same for N=10,20, 30 and 100
> plot(ecdf(Bin20),main='N=20')
> lines(k,ppois(k,lambda),type='s',col='red')
>
> plot(ecdf(Bin30),main='N=30')
> lines(k,ppois(k,lambda),type='s',col='red')
> 
> plot(ecdf(Bin100),main='N=100')
> lines(k,ppois(k,lambda),type='s',col='red')
> 