clear all


%John Carroll
%Lab05.m
%9/27/2011
%Our objective is to solve for the distance that water balloons have to travel from the balcony to the swimming pool.
%I have to compute the distance of the water balloon's travels given the balloon launch angle (theta) in degrees, 
%balloon launch velocity (v) in min/sec, and the thrower’s height in feet.
%We have to find out how many balloons it takes to fill the pool.
%We will continue to "throw" balloons while the pool is not full, i.e. while the
%total amount of water from the “hit” balloons is less than the capacity of
%the pool. When the pool is full, my program will display the number
%of balloons thrown, the number of balloons that hit the pool, and the percent of hits.


clc;                                   %To clear all
clear all;


% =======================================================================
% *****CONSTANTS*****

BALCONY_HT = 12;                               %Balcony height in feet
G = 32;                                        %Gravitational acceleration in ft/s^2
POOL_CENTER = 35;                              %Distance to the center of pool
MIN_THETA = 5; MAX_THETA = 85;                 %The angles minimums and maximums in degrees
MIN_VELOCITY = 1; MAX_VELOCITY = 30;           %The min and max velocities of the throw shown in ft/sec
MIN_THROWERS_HT = 4.5; MAX_THROWERS_HT = 7.0;  %The min and max height of the thrower shown in feet
MIN_DIAM = 3; MAX_DIAM = 9;                    %Diameter of the balloons in inches
CAPACITY = 7;                                  %Capacity of the pool in gallons.





% =======================================================================
% *****COMPUTATION*****

amount_of_water = 0;                           %The initial number of gallons in the pool.
balloons_that_hit = 0;                         %The initial number of balloons that hit.
balloons_thrown = 0;                           %The initial number of balloons that were thrown.

while amount_of_water < CAPACITY               %This basically states that while the amount of water is less than the pool capacity, it will
                                               %continue to do everything within the function until it meets the target.
    
    % =====================================================================
    % *****INPUT*****
    theta = (MAX_THETA-MIN_THETA) * rand (1) + MIN_THETA;                               %This creates a random matrix within the limits of the angle theta for the balloon launch angle
    velocity = (MAX_VELOCITY-MIN_VELOCITY) * rand (1) + MIN_VELOCITY;                   %This creates a random matrix within the limits of the velocity for the balloon launch velocity
    throwers_ht = (MAX_THROWERS_HT-MIN_THROWERS_HT) * rand (1) + MIN_THROWERS_HT;       %This creates a random matrix within the limits of the thrower's height
    balloon_ht = (BALCONY_HT + throwers_ht);                                            %This is the equation to establish the height of the balloon when thrown
    diameter = round((MAX_DIAM-MIN_DIAM) * rand (1) + MIN_DIAM);                        %This creates a random matrix within the range of the balloon's diameter
    a = (velocity*cosd(theta))/G;                                                       %This is part a of the equation that consists of "velocity*cosd(theta)/G"
    b = (velocity*sind(theta));                                                         %This is part b of the equation that consists of "velocity*sind(theta)"
    c = sqrt(b^2 +(2*G*balloon_ht));                                                    %This is part c of the equation that consists of "sqrt(b^2 +(2*G*balloon_ht))"
    distance =(a*(b+c));                                                                %The combined equation resulting in the computed distance
    distances_that_hit = distance >= (POOL_CENTER - 1) && distance <= (POOL_CENTER +1); %This is used to find what distances hit the pool.
    
    %This if function is used to find the number of balloons that hit the pool.
    if distances_that_hit                                      
        balloons_that_hit = balloons_that_hit +1;
        switch diameter
            case 3     %i.e If the diameter is 3, then the volume it holds is 0.1 gallons.
                amount_of_water = amount_of_water + 0.1;
            case 4
                amount_of_water = amount_of_water + 0.2;
            case 5
                amount_of_water = amount_of_water + 0.3;
            case 6
                amount_of_water = amount_of_water + 0.55;
            case 7
                amount_of_water = amount_of_water + 0.8;
            case 8
                amount_of_water = amount_of_water + 1.25;
            case 9
                amount_of_water = amount_of_water + 1.7;
        end %ends the switch
        
    end %ends the 'if' function
    
    %This function is used to find the number of balloons that were thrown.
    balloons_thrown = balloons_thrown + 1;
end  %end the while loop

%This is the calculation used to find the percent of hits.
percentage_of_hit = (balloons_that_hit/balloons_thrown)*100;

% ========================================================================
% *****OUTPUT*****
format compact                                     %Used  to suppress extra line-feeds
disp('Number of balloons that hit the pool.')      %String used to make the title header for the balloons_that_hit.
disp(balloons_that_hit)                            %Displays the actual number of balloons that hit.
disp('Number of balloons that were thrown.')
disp(balloons_thrown)
disp('Percentage of balloons that hit the pool.')
disp(percentage_of_hit)

