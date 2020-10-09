# Author : Marc Cabo Dieguez
# Date : 08/10/2021
# Ejercici 3 - L'usuari entra el diametre d'una pizza rodona i s'imprimeiz la seva superfície
import math

diametre = float(input("Introduce el diametro de la pizza : "))

# Formula Radi = Diametre / 2
radio = diametre / 2

# Formula Superfice = PI * r^2
superficie = math.pi * radio ** 2

print("Superficie total : " + str(math.pi * radio ** 2))
