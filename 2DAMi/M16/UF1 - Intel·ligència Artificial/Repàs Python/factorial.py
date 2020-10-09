# Author : Marc Cabo Dieguez
# Date : 08/10/2021
# Ejercici 6 - L'usuari escriu un enter i s'imprimeix el seu factorial

num = int(input("Introduce un número : "))
factorial = 1

for fact in range(1, (num + 1)):
    factorial = factorial * fact

print("El factorial de " + str(num) + " es " + str(factorial))
