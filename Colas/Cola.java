package Colas;

class Cola {
    private String[] elementos;
    private int frente;
    private int fin;
    private int tamanio;


    public Cola(int capacidad) {
        elementos = new String[capacidad];
        frente = 0;
        fin = -1;
        tamanio = 0;
    }

    public void encolar(String elemento) {
        if (estaLlena()) {
            throw new RuntimeException("La impresora alcanzó el limite maximo");
        }
        fin = (fin + 1) % elementos.length;
        elementos[fin] = elemento;
        tamanio++;
        System.out.println("El archivo " + elemento + " ha sido preparado");
    }

    public void desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("La impresora no tiene archivos para imprimir");
        }
        String elemento = elementos[frente];
        frente = (frente + 1) % elementos.length;
        tamanio--;
        System.out.println(elemento + " se ha imprimido correctamente");
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public boolean estaLlena() {
        return tamanio == elementos.length;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("Lista Vacia");
            return;
        }
        System.out.print("Archivos preparados para imprimir: ");
        for (int i = 0; i < tamanio; i++) {
            System.out.print(elementos[(frente + i) % elementos.length] + "\n");
        }
        System.out.println();
    }
}