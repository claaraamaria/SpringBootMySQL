curl localhost:5000/rooms -d roomName=TicTacToeGame -d gameId=6 -d userId=10

curl http://server-env.eba-xyvg76az.eu-central-1.elasticbeanstalk.com/users -d userName=TicTacToeGame -d password=nu_am_parola

curl -X DELETE http://localhost:5000/users/10
curl http://server-env.eba-xyvg76az.eu-central-1.elasticbeanstalk.com/users -d userName=TicTacToeGame -d password=nu_am_parola