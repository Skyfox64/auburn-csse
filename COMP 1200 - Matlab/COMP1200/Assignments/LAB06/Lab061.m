clear all


%John Carroll
%Lab06.m
%10/20/2011
% The purpose of this assignment is to get the user to enter in data, turning it into an index.
% The program will then compute the number of pairs, and the sums needed to compute the slope and y-intercept.
% It will also place this data into a table and show the slope and y-intercept in the form of a linear equation. 
% The user will be able to enter one of the velocities entered earlier and get the distance using the linear equation that is created in my program.

clc;                                   %To clear all
clear all;


% =======================================================================
% ***** INITIALIZE *****
% initialize counter and accumulators 
vel_counter = 1;
vel_total = 0;
dist_counter = 0;
dist_total = 0;

vel(vel_counter) = input('Enter the velocity of a nebula(enter 0 to stop): ');

% =======================================================================
% ***** INPUT *****
% while velocity not = 0 
if vel(vel_counter) == 0
    break
end

% ask user to enter a velocity and distance
% add values to vectors
% increment counter
while vel(vel_counter) ~= 0
    dist_counter = dist_counter + 1;
    dist(dist_counter) = input('Enter the distance of a nebula: ');
    vel_counter = vel_counter + 1;
    vel(vel_counter) = input('Enter the velocity of a nebula(enter 0 to stop): ');
end



% =======================================================================
% ***** COMPUTE *****
% Counters
dist_counter = dist_counter + 1;
vel_counter = vel_counter - 1;
vel(end) = [];

% accumulate into sums data
slope = ((vel_counter)*sum(vel.*dist)-sum(vel)*sum(dist))/((vel_counter)*sum(vel.*vel)-sum(vel)*sum(vel)); % compute SLOPE (m)
intercept = (sum(dist)*sum(vel.*vel)-sum(vel)*sum(vel.*dist))/((vel_counter)*sum(vel.*vel)-sum(vel)*sum(vel)); % compute INTERCEPT (b)

% =======================================================================
% ***** OUTPUT *****
% print velocity and distance data in table
% Print Headers
fprintf('\n  NEBULA INPUT DATA\n');
fprintf(' VELOCITY  DISTANCE\n');
fprintf('  km/sec  106 parsecs\n');

% Print Velocities and Distances Right Aligned
for g = 1 : vel_counter
    vel_total = vel_total + vel(g);
    dist_total = dist_total + dist(g);
    fprintf('%7d %10.3f\n', vel(g), dist(g));
end

% print LINEAR EQUATION -- y = mx + b
fprintf('\nLINEAR EQUATION: distance = %7.4f * velocity + %5.3f\n', slope, intercept);

% =======================================================================
% *****USE LINEAR EQUATION*****
% compute distance using linear equation

% ask user for velocity
x = input('\nEnter a velocity of a nebula from above: ');
while x ~= vel
    fprintf('Not a velocity from above. Try again.'); % print if wrong Velocity is entered
    x = input('\nEnter a velocity of a nebula from above: ');
end

% Find the distance given slope and y-intercept 
y = slope * x + intercept;
% print velocity and distance
fprintf('For velocity = %3d, distance = %5.3f\n', x, y); 


