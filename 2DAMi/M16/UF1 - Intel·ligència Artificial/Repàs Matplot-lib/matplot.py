# Author : Marc Cabo Dieguez
# Date : 15/10/2021
# Ejercici 1 -
import matplotlib.pyplot as plt
import numpy as np

x = np.linspace(-2, 2, 10)

plt.plot(x, x, "-", label='Linial')
plt.plot(x, (x*x),"o", label = 'Quadràtica')
plt.plot(x, (x*x*x),".", label = 'Cúbica')
plt.xlabel('Valors de X')
plt.ylabel('Valors de Y')
plt.title("Funcions")
plt.legend()
plt.show()
