#!/bin/bash

while true;
do
sleep 0;
curl --location --request POST 'localhost:30000/hubs' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title":"Consultorio da Dr. Suelen",
    "description": "Agende hoje sua consulta conosco!",
    "profilePhotoUrl": "https://assim.com.br/site/img/rede-credenciada-img.jpg",
    "contacts": [
        {
        "description": "WhatsApp (64) 9999-52643",
        "icon": "fa-whatsapp",
        "linkToRedirect": "https://api.whatsapp.com/send?phone=5564999952643&text=ol%C3%A1%20seja%20bem%20vindo"
        },
        {
        "description": "Instagran",
        "icon": "fa-instagran",
        "linkToRedirect": "https://www.instagram.com/grupoapheto"
        }
    ]
}'
echo -e '\n\n'$(date);
done
