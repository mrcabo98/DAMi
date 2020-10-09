# Author : Marc Cabo Dieguez
# Date : 08/10/2021
# Ejercici 4 - L'usuari escriu un enter i s'imprimei true si existeix un billet d'euros amb la quantitat entrada, false en qualsevol altre cas.

n = (int(input("Introduce el valor : ")))

if n == 5 \
        or n == 10 \
        or n == 20 \
        or n == 50 \
        or n == 100 \
        or n == 200 \
        or n == 500:
    print("Es correcto")
else:
    print("No es correcto")
