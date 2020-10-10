# Author : Marc Cabo Dieguez
# Date : 10/10/2021
# Ejercici 2 - L'usuari introdueix una paraula i imprimeix si es palíndroma o no

palabra = str(input("Introduce una palabra : "))

if str(palabra) == str(palabra)[::-1]:
    print("La palabra '" + palabra + "' és palindroma")
else:
    print("La palabra '" + palabra + "' NO és palindroma")
