# Author : Marc Cabo Dieguez
# Date : 10/10/2021
# Ejercici 3 - L'usuari introdueix un enter i s'imprimeixen les n primeres files del Triangle de Pascal

numero = int(input("Introduce el número de filas :  "))
fila = []

for i in range(numero):
    fila.append([])
    fila[i].append(1)

    for j in range(1, i):
        fila[i].append(fila[i - 1][j - 1] + fila[i - 1][j])
    if (numero != 0):
        fila[i].append(1)

for i in range(numero):
    print("   " * (numero - i), end=" ", sep=" ")

    for j in range(0, i + 1):
        print('{0:5}'.format(fila[i][j]), end=" ", sep=" ")
    print()
