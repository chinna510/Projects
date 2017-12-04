library(plotrix)

x <- c(99, 62, 10, 53)
labels <- c("London", "New York", "Singapore", "Mumbai")

# Pie Chart With Default Colors
png(file = "city.jpg")
pie(x, labels)
dev.off()
# Pie chart with Colors
png(file = "city_with_colors.jpg")
pie(x, labels ,main = "Sales Chart ", col = rainbow(length(x)))

dev.off()
percentile <-round(100*x/sum(x),1)
png(file= "City_With_Percentile")
pie(x, labels = percentile, main = "Chart_With_Percentile ", col = rainbow(length(x)))

legend("topright", c("London", "New York", "Singapore", "Mumbai"), cex = 0.8 ,fill=rainbow(length(x)))

dev.off()
png(file = "3d_city_with_colors.jpg")

pie3D(x, labels = labels, explode = 0.1 , main="3d_Pie_Chart")

dev.off()

