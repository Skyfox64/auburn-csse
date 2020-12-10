clear all

%John Carroll
%Lab03.m
%9/15/2011
%We have a vector from the angles 5 to 85 degrees.
%Our objective is to solve for the distance that water balloons have to travel from the balcony to the swimming pool.
%I have to compute the distance of the water balloon's travels given the balloon 
%launch angle (theta) in degrees, balloon launch velocity (v) in min/sec, and the thrower�s height in feet.

clc;                                   %to clear all
clear all;

format bank;                           %to restrict output to two decimal places

% Inputs
% Constants
BALCONY_HT = 12;               %balcony height in feet
G = 32;                        %gravitational acceleration in ft/s^2
MIN_THETA = 5; MAX_THETA = 85;                 %the angles minimums and maximums in degrees
MIN_VELOCITY = 1; MAX_VELOCITY = 30;           %the min and max velocities of the throw shown in ft/sec
MIN_THROWERS_HT = 4.5; MAX_THROWERS_HT = 7.0;  %the min and max height of the thrower shown in feet

% Code
% Get angle theta, velocity, and thrower's height using rand() to create vectors of 7 values each
theta = (85-5) * rand (7,1) + 5;                        %this creates a random matrix within the limits of the angle theta for the balloon launch angle
velocity = (30-1) * rand (7,1) + 1;                     %this creates a random matrix within the limits of the velocity for the balloon launch velocity
throwers_ht = (7.0-4.5) * rand (7,1) + 4.5;               %this creates a random matrix within the limits of the thrower's height
balloon_ht = (12 + throwers_ht);                    %this is the equation to establish the height of the balloon when thrown
a = (velocity.*cosd(theta))/G;                      %this is part a of the equation that consists of "velocity*cosd(theta)/G"
b = (velocity.*sind(theta));                        %this is part b of the equation that consists of "velocity*sind(theta)"
c = sqrt(b.^2 +(2*G.*balloon_ht));                  %this is part c of the equation that consists of "sqrt(b^2 +(2*G*balloon_ht))"
distance = a' .*(b' + c');                          %the combined equation resulting in the computed distance
n = [theta, velocity, throwers_ht, distance'];      %the information fully computed and ready to be displayed in a 4x7 matrix

% PART 1 - Mean
% Compute the horizontal distance using mean of each vector
disp('         theta       velocity      throwers_ht    distance')   %the header for the final table
k = mean(n);                                                         %the variable k is used to stand for the mean of n
% Display a vector containing theta, vel, thrower�s ht, distance with column headers
disp(k)                                                              %this is to display k under the header

% PART 2 - 2-D Matrix
% Compute the horizontal distance using input vectors
disp('         theta       velocity      throwers_ht    distance')      %the header for the final table
% Display a table containing theta, velocity, thrower's ht, distance with column headers
disp(n)                                                                 %this is to display n under the header

% PART 3 - Colon Notation
% Compute the values for the 4th column of table (horizontal distance) using table columns in the table created in PART3 as input use colon notation, not vector names
format short                                          %to restrict output to two decimal places
balloon_ht = (12 + n(:,3));                           %this is the equation to establish the height of the balloon when thrown using the data from the third column of the matrix
a = (n(:,2).*cosd(n(:,1)))/G;                         %this is part a of the equation that consists of "velocity*cosd(theta)/G" but by using the data from the first column of the matrix
b = (n(:,2).*sind(n(:,1)));                           %this is part b of the equation that consists of "velocity*sind(theta)" but by using the data from the first column of the matrix
c = sqrt(b.^2 +(2*G.*balloon_ht));                    %this is part c of the equation that consists of "sqrt(b^2 +(2*G*balloon_ht))"
distance = a' .*(b' + c');                            %the combined equation resulting in the computed distance
m = [theta, velocity, throwers_ht, distance'];        %the information fully computed and ready to be displayed in a 4x7 matrix
disp('    theta   velocity throwers_ht distance')     %the header for the final table
% Display a table containing theta, velocity, thrower�s ht, distance with column headers
disp(m)                                               %this is to display m under the header

% PART 4 - Nested functions
% Display the mean of each column in table created in PART 3
disp('    theta   velocity throwers_ht distance')     %the header for the final table
disp(mean(m))                                         %this is the nested function used to display the output as it is a function within a function
