#include <iostream>
#include <conio.h>
#include <string>
#include <vector>

using namespace std;

struct disciplina{
    string nome;
};

string indicador = "->";
string indicadorVazio = "  ";

vector<disciplina> bancoDados;


int exibeDisciplinas(){

    char keyPressed;

    while(1){

        system("CLS");
        if (bancoDados.size() == 0){
            cout << "Nenhuma disciplina cadastrada";
        }

        keyPressed = getch();

        if (int(keyPressed) == int('a')){
            return 1;
        }
    }
}


int exibeConfiguracoes(){
    cout << "configuracoes" << endl;
    return -1;
}

void run(){

    char keyPressed;
    string lista[2];
    int posIndicador = 0;
    lista[0] = indicador;
    lista[1] = indicadorVazio;

    while (1){
        system("CLS");
        cout << lista[0] << " Disciplinas" << endl;
        cout << lista[1] << " Configuracoes" << endl;

        keyPressed = getch();
        if (int(keyPressed) == int('s')){

            lista[posIndicador] = indicadorVazio;
            posIndicador = (posIndicador+1) % 2;
            lista[posIndicador] = indicador;
        }

        else if (int(keyPressed) == int('d')){

            if (posIndicador == 0){
                if (exibeDisciplinas() == -1){
                    return;
                }
            }
            else{
                if (exibeConfiguracoes() == -1){
                    return;
                }
            }
        }

        else if (int(keyPressed) == int('a')){
            return;
        }
    }
}

int main(){

    run();
}
