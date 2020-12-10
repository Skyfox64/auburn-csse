clear all


%John Carroll
%Lab04.m
%9/22/2011
%We have a vector from the angles 5 to 85 degrees.
%Our objective is to solve for the distance that water balloons have to travel from the balcony to the swimming pool.
%I have to compute the distance of the water balloon's travels given the balloon 
%launch angle (theta) in degrees, balloon launch velocity (v) in min/sec, and the thrower’s height in feet.
% We have to compute the distances to see which of them will hit the target, will be too short, or be too long. 
% We also have to find the distance average and see if it, too, will hit the pool.


clc;                                   %To clear all
clear all;

format bank;                           %Used to restrict output to two decimal places




% =======================================================================
% *****CONSTANTS*****

BALCONY_HT = 12;                               %Balcony height in feet
G = 32;                                        %Gravitational acceleration in ft/s^2
MIN_THETA = 5; MAX_THETA = 85;                 %The angles minimums and maximums in degrees
MIN_VELOCITY = 1; MAX_VELOCITY = 30;           %The min and max velocities of the throw shown in ft/sec
MIN_THROWERS_HT = 4.5; MAX_THROWERS_HT = 7.0;  %The min and max height of the thrower shown in feet
POOL_CENTER = 35;                              %Distance to the center of pool




% =======================================================================
% *****INPUT*****

% Get angle theta, velocity, and thrower's height using rand() to create vectors of 7 values each
theta = (85-5) * rand (7,1) + 5;                    %This creates a random matrix within the limits of the angle theta for the balloon launch angle
velocity = (30-1) * rand (7,1) + 1;                 %This creates a random matrix within the limits of the velocity for the balloon launch velocity
throwers_ht = (7.0-4.5) * rand (7,1) + 4.5;         %This creates a random matrix within the limits of the thrower's height
balloon_ht = (12 + throwers_ht);                    %This is the equation to establish the height of the balloon when thrown




% =======================================================================
% *****COMPUTATION*****

% Compute the horizontal distance using input vectors
a = (velocity.*cosd(theta))/G;                      %This is part a of the equation that consists of "velocity*cosd(theta)/G"
b = (velocity.*sind(theta));                        %This is part b of the equation that consists of "velocity*sind(theta)"
c = sqrt(b.^2 +(2*G.*balloon_ht));                  %This is part c of the equation that consists of "sqrt(b^2 +(2*G*balloon_ht))"
distance = a' .*(b' + c');                          %The combined equation resulting in the computed distance

% Combine vectors as a matrix
n = [theta, velocity, throwers_ht, distance'];      %The information fully computed and ready to be displayed in a 4x7 matrix

% Find distances in the matrix that are too short, too long, a hit
j = find(n(:,4) <= POOL_CENTER - 1);                               %This variable finds the distances that are too short to hit the pool.
k = find(n(:,4) >= POOL_CENTER + 1);                               %This variable finds the distances that are too long to hit the pool.
l = find(n(:,4) < POOL_CENTER + 1 & n(:,4) > POOL_CENTER - 1);     %This variable finds the distances that hit the pool.




% ========================================================================
% *****OUTPUT*****

% *Matrix*
% -Acquire the distances that a water balloon will travel.
% -Display the matrix containing theta, velocity, thrower’s height, and distance with column headers.
disp('         Theta       Velocity      Throwers_ht    Distance')   %The column header for the final table.
disp(n)                                                              %The display for the matrix containing theta, velocity, thrower’s height, and distance.






% *Distances*
% Find and display:
%   -The distances that are too short
%   -The distances that are too long
%   -The distances that hit the pool

% Display the distances that are too short. 
      %If the vector is empty, display a message.
if isempty(j)                                        %This finds if there are any distances in the category that are too short to hit the pool.
    disp('No distances are too short.')              %If there are none in this criteria, then the function displays 'No distances are too short.'
    disp(' ')                                        %This is a blank line which is used for output spacing.
else                                                 %If the 'if' statement isn't met then it continues onto this statement.
    disp('Distances that were too short.')           %If there are distances in this criteria, then the function displays 'Distances that were too short.'
    disp(n(j,4))                                     %Using this, it also displays the distances that met the criteria.
end                                                  %This ends the 'if' statement.

% Display the distances that are too long. 
      %If the vector is empty, display a message.
if isempty(k)                                        %This finds if there are any distances in the category that are too long to hit the pool.
    disp('No distances are too long.')               %If there are none in this criteria, then the function displays 'No distances are too long.'
    disp(' ')                                        %This is a blank line which is used for output spacing.
else                                                 %If the 'if' statement isn't met then it continues onto this statement.
    disp('Distances that were too long.')            %If there are distances in this criteria, then the function displays 'Distances that were too long.'
    disp(n(k,4))                                     %Using this, it also displays the distances that met the criteria.
end                                                  %This ends the 'if' statement.

% Display the distances that hit the pool. 
      %If the vector is empty, display a message.
if isempty(l)                                        %This finds if there are any distances in the category that hit the pool.
    disp('No distances hit the pool.')               %If there are none in this criteria, then the function displays 'No distances hit the pool.'
    disp(' ')                                        %This is a blank line which is used for output spacing.
else                                                 %If the 'if' statement isn't met then it continues onto this statement.
    disp('Distances that hit the pool.')             %If there are distances in this criteria, then the function displays 'Distances that hit the pool.'
    disp(n(l,4))                                     %Using this, it also displays the distances that met the criteria.
end                                                  %This ends the 'if' statement.






% *Average Distance*
% -Find average distance
disp('Average Distance:')                                  %Header for the Average Distance
avg = mean(n(:,4));                                        %Variable used to stand for the average of the distances
disp(avg)                                                  %Used to display the actual average distance, under the header

% -Determine if average distance hit the pool
     %distance too short
     %distance too long 
     %distance is a hit
% -Display message about average distance%
if find(avg <= POOL_CENTER - 1);                           %This finds if the average distance is in the category that is too short.
    disp('Average distance is too short.')                 %If there are distances in this criteria, then the function displays 'Average distance is too short.'
    disp(' ')                                              %This is a blank line which is used for output spacing.
elseif find(avg >= POOL_CENTER + 1);                       %This finds if the average distance is in the category that is too long.
    disp('Average distance is too long.')                  %If there are distances in this criteria, then the function displays 'Average distance is too long.'
    disp(' ')                                              %This is a blank line which is used for output spacing.
else find(avg < POOL_CENTER + 1 & avg > POOL_CENTER - 1);  %This finds if the average distance is in the category that hits the pool.
    disp('Average distance hits the pool.')                %If there are distances in this criteria, then the function displays 'Average distance hits the pool.'
    disp(' ')                                              %This is a blank line which is used for output spacing.
end                                                        %This ends the 'if' statement.