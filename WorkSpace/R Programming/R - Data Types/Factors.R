# Vector Creation

apple_colors <- c('Red','Yellow', 'Red','Green','Red','Yellow','Blue','red')

print(apple_colors)

# Factoring The Vector
factor_colores <- factor(apple_colors)

# Print The Distinct Colors Of Apples
print(factor_colores)

# Count The Number Of Distant Colors Of Apples
print(nlevels(factor_colores))