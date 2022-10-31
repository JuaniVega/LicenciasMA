#!/bin/bash
#author - Matias Ifran - m.ifran@santafeciudad.gov.ar

#DO NOT EDIT
echo '
	███╗░░░███╗░█████╗░░██████╗███████╗
	████╗░████║██╔══██╗██╔════╝██╔════╝
	██╔████╔██║██║░░╚═╝╚█████╗░█████╗░░
	██║╚██╔╝██║██║░░██╗░╚═══██╗██╔══╝░░
	██║░╚═╝░██║╚█████╔╝██████╔╝██║░░░░░
	╚═╝░░░░░╚═╝░╚════╝░╚═════╝░╚═╝░░░░░';

#text format and color
BOLD='\e[1m';
RED='\e[31m'
GREEN='\e[32m'
NB='\e[21m'; # reset Bold
NC='\e[39m' # reset Color
NF='\e[0m' #reset to Normal - no format

#exit when detect any fails.
set -e

if [ $# -eq 0 ]
  then
    
    printf "\n${BOLD}Help>${NF} Utilice este comando para crear nuevas ramas con nuestra convención de nombres. 
	Por Ejemplo: ${BOLD}7304: Resumen Mantis ${NF}

	Para forzar la creación de una rama sin nombre de convención, entonces use ${BOLD}git branch${NF} o ${BOLD}git checkout${NF} en su lugar.\n"
    #collect data from input
    read -rp "Ingrese el nombre el branch (ID de la tarea y resumen): " BRANCH
  else
    BRANCH="$*"
fi

#Branch prefix check
PREFIX=$( echo $BRANCH | sed -rn 's/[^0-9]*([0-9]+).*/\1/gp')

echo -e "Ticket https://mantis.santafeciudad.gov.ar/view.php?id=$PREFIX\n"

if [[ -z "${PREFIX//[0-9]}" && -n "$PREFIX" ]]
then
  git checkout -b `echo $BRANCH | iconv -t ascii//TRANSLIT | sed -r 's/[~\^]+//g' | sed -r 's/[^a-zA-Z0-9]+/-/g' | sed -e 's/_/-/g' | sed -r 's/^-+\|-+$//g' | tr A-Z a-z`
  sleep 2
else
  echo -e "${RED} > Error:${NC} El nombre del branch debe comenzar con un número de ticket"
  sleep 5
  exit 1
fi
