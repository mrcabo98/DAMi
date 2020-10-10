# Author : Marc Cabo Dieguez
# Date : 10/10/2021
# Ejercici 1 - L'usuari introdueix dos nombres enters, inici i final i es genera una llista

llista = []
num1 = int(input("Introduce el primer número : "))
num2 = int(input("Introduce el segundo número : "))

for i in range(num1, num2 + 1):
    llista.append(i)
print(llista)
