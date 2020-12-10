%John Carroll
%Lab07
%Due October 27, 2011
%{
   Edwin Hubble used the Mount Wilson Observatory telescopes to measure
features of nebulae outside the Milky Way. He found that there is a
relationship between a nebula’s distance from earth and the velocity with
which it was traveling from the earth. Hubble’s initial data on 24 nebula
is presented in Table 1 in the problem scenario.
    The relationship between distance and velocity led scientists to propose
that the universe came into being with a Big Bang, a long time ago. If
material scattered from the point of the Big Bang traveling at a constant
velocity, the distance traveled can be determined.

-The program will need to build vectors to store from the velocites and distances that are
given by the "hubbleData.txt" file. It will also compute the sums that are needed.
It will find the slope and y-intercept and it will also print the velocity and
distance vectors. By using all of this information it will plot a "velocity
vs. distance" graph.
%}


clc
clear all

% =======================================================================
% ***** INITIALIZE *****
distance_sum=0;  %initializes the summation of the distances
velocity_sum=0;  %initializes the summation of the velocities
velocity_sum_sq=0; %initializes the summation of the velocities squared
velocity_and_distance_sum=0; %initializes the summation of the velocities*distances



% =======================================================================
% ***** INPUT *****
%Read Hubble's data from hubbleData.txt

file_id = fopen('hubbleData.txt','r');

if file_id < 0
    error('Error:Could not open "hubbleData"');
else
    r = 1;
    %Use a while loop for reading the data file.
    while ~feof(file_id)
        object(r,:) = fscanf(file_id,'%f',1);
        distance(r,:) = fscanf(file_id, '%f', 1);
        velocity(r,:) = fscanf(file_id, '%f', 1);
        mt(r,:) = fscanf(file_id, '%f', 1);
        mT(r,:) = fscanf(file_id, '%f', 1);
        
        table = [object, distance, velocity, mt, mT];
        r = r + 1;
    end
%Use counting loops when summing data and printing table.

    %Print the velocities and distances in a two columns with a title and
    %column headings
 
    r = r - 1;
fprintf('\n   NEBULA INPUT DATA \n VELOCITY    DISTANCE \n   km/sec  106 parsecs \n');
    for m = 1 : r
        fprintf('    %4d    %5.3f\n', velocity(m), distance(m));
        
    end
end


for    p=1:r
    distance_sum = distance_sum + distance(p);
    velocity_sum = velocity_sum + velocity(p);
    velocity_sum_sq = (velocity_sum_sq + velocity(p).^2);
    velocity_and_distance_sum = velocity_and_distance_sum + (velocity(p).*distance(p));
end;

% =======================================================================
% ***** COMPUTATION *****
%Create the linear equation that estimates the relationship between the
%velocity and distance readings.
slope_1 = (r.*velocity_and_distance_sum - velocity_sum.*distance_sum);
slope_2 = (r.*velocity_sum_sq - (velocity_sum.^2));
slope = slope_1/slope_2;
intercept_1 = ((distance_sum.*velocity_sum_sq)-(velocity_sum.*velocity_and_distance_sum));
intercept_2 = (r.*velocity_sum_sq - (velocity_sum.^2));
intercept = intercept_1/intercept_2;

ordered_velocity = sort(velocity);
distance = slope.*ordered_velocity + intercept;

%Draw a scatter plot and the line graph for the data pairs
scatter(table(:,3), table(:,2));
hold on

% =======================================================================
% ***** OUTPUT *****
%Print the slope and y-intercept in the form of a linear equation.
fprintf('\nlinear equation: distance= %5.4f*velocity + %4.3f\n',slope, intercept); 
%Display the data in a scatter plot and line graph
plot(ordered_velocity,distance);

