# Author : Marc Cabo Dieguez
# Date : 08/10/2021
# Ejercici 5 - L'usuari escriu un enter i s'imprimeix el nombre en valor absolut

num = int(input("Introduce un número : "))

if num < 0:
    num = -num
print(num)
