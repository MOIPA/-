all:server client

client:client.o
	gcc -o client client.o
client.o:client.c
	gcc -c client.c
server:server.o
	gcc -g -o server server.o -lpthread
server.o: server.c
	gcc -g -c server.c -lpthread
clean:
	rm *.o 
