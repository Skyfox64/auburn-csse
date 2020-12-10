#
# 'make' build executables and object files
# 'make clean' removes all .o and executable files
#

# define the C compiler to use
# Compiler
CC = g++ -std=c++0x

# define any compile-time flags
CFLAGS = -Wall -g

all: client server

client: packet.o client.cpp
	$(CC) $(CFLAGS) packet.o -o client client.cpp

server: packet.o server.cpp
	$(CC) $(CFLAGS) packet.o -o server server.cpp

packet.o: packet.h packet.cpp
	$(CC) $(CFLAGS) -c packet.cpp

clean:
	$(RM) *.o *~ $(MAIN)