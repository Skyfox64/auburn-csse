%John Carroll
%Lab02.m
%9/8/2011
%We have a vector of the angles 5 to 85 degrees and at intervals of 10 degrees.
%Our objective is to solve for the distance that water balloons have to travel from the balcony to the swimming pool.
%After acquiring my values for the distances, I placed the angles along with their distances in a matrix.
clc;
clear all;

% Inputs
BALCONY_HT = 12;               %balcony height in feet
G = 32;                        %gravitational acceleration in ft/s^2
MIN_THETA = 5; MAX_THETA = 85                 %degrees
MIN_VELOCITY = 1; MAX_VELOCITY = 30           %ft/sec
MIN_THROWERS_HT = 4.5; MAX_THROWERS_HT = 7.0; %feet

% Code
% PART 1
% PART 2
disp('      THETA   VELOCITY   THROWERS_HT   DISTANCE')
THETA = (85-5) * rand (7,1);
VELOCITY = (30-1) * rand (7,1);
THROWERS_HT = (7.0-4.5) * rand (7,1);
BALLOON_HT = (12 THROWERS_HT);
m = (VELOCITY. *cosd(THETA))/G;
b = (VELOCITY. *sind(THETA))/G;
c = sqrt(b. ^2 +(2 *G. *BALLOON_HEIGHT));
DISTANCE = m' .*(b' + c');
n = [THETA, VELOCITY, THROWERS_HT, DISTANCE'];
disp(n)
