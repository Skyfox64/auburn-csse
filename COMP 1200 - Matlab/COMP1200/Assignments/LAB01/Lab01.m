% John Carroll
% Lab01.m
% COMP1200-M - Fall 2011
% CIRCLE - A script file to draw a pretty circle
clc, clear all
% build vectors
angle = linspace (0, 2*pi, 360);
x = cos(angle);
y = sin(angle);
% draw a circle
plot (x,y)
axis('equal')
ylabel('y')
xlabel('x')
title('Pretty Circle')
grid on
% print message
disp('Congratulations!');
