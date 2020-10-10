# Author : Marc Cabo Dieguez
# Date : 10/10/2021
# Ejercici 3 - L'usuari introdueix una llista d'enters separats per comes (,) i s'imprimeix el nombre d'elements i la suma d'ells

llista = [1, 3, 5, 8, 10, 11, 14, 15, 16, 19, 20]
i = 0;

while i < len(llista):
    if llista[i] % 2 == 0:
        print(llista[i], end=" ")
    i += 1
