# Author : Marc Cabo Dieguez
# Date : 10/10/2021
# Ejercici 2 - L'usuari introdueix una llista d'enters separats per comes (,) i s'imprimeix el nombre d'elements i la suma d'ells

llista = [1, 3, 5, 6, 7, 10, 13, 20, 45]
suma = 0

for i in llista:
    suma = suma + i

print("La suma total de los elementos que se encuentran en la lista es de : " + str(suma))
print("La lista tiene un total de " + str(len(llista)) + " elementos")
