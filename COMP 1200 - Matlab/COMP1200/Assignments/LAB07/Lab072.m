%John Carroll
%Lab07
%Due October 27, 2011
%{
   Edwin Hubble used the Mount Wilson Observatory telescopes to measure
features of nebulae outside the Milky Way. He found that there is a
relationship between a nebula�s distance from earth and the velocity with
which it was traveling from the earth. Hubble�s initial data on 24 nebula
is presented in Table 1 in the problem scenario. 
    The relationship between distance and velocity led scientists to propose 
that the universe came into being with a Big Bang, a long time ago. If 
material scattered from the point of the Big Bang traveling at a constant 
velocity, the distance traveled can be determined.

   -The program will build vectors to store velocites and distances that are 
from the "hubbleData.txt" file. It will also compute the sums that are needed. 
It will find the slope and y-intercept and it will print the velocity and 
distance vectors. By using all of this information it will plot a "velocity 
vs. distance" graph.
%}

clc
clear all


%This program will build vectors to store velocites and distances that are
%input from the hubbleData file and compute the sums that are needed find the slope and
%y-intercept. It will print the velocity and distance vectors and give a
%linear equation relating the information. The data will be displayed on a
%graph.

clc, clear all

file_id = fopen('hubbleData.txt','r');

if file_id < 0
    error('Error:Could not open "hubbleData"');
else
    r = 1;
    
    while ~feof(file_id)
        object(r,:) = fscanf(file_id,'%f',1);
        distance(r,:) = fscanf(file_id, '%f', 1);
        velocity(r,:) = fscanf(file_id, '%f', 1);
        mt(r,:) = fscanf(file_id, '%f', 1);
        mT(r,:) = fscanf(file_id, '%f', 1);
        
        table = [object, distance, velocity, mt, mT];
        r = r + 1;
    end
    r = r - 1;
    fprintf('\n   NEBULA INPUT DATA \n VELOCITY    DISTANCE \n   km/sec  106 parsecs \n');

    
    for m = 1 : r
        fprintf('    %4d    %5.3f\n', velocity(m), distance(m));
        
    end
end

%Initializations:
summation_distance=0;  %initializes the summation of the distances
summation_velocity=0;  %initializes the summation of the velocities
summation_velocity_sq=0; %initializes the summation of the velocities squared
summation_velocity_distance=0; %initializes the summation of the velocities*distances

for    k=1:r
    summation_distance = summation_distance + distance(k);
    summation_velocity = summation_velocity + velocity(k);
    summation_velocity_sq = (summation_velocity_sq + velocity(k).^2);
    summation_velocity_distance = summation_velocity_distance + (velocity(k).*distance(k));
end;
%Linear Equation:

slope_1 = (r.*summation_velocity_distance - summation_velocity.*summation_distance);
slope_2 = (r.*summation_velocity_sq - (summation_velocity.^2));
slope = slope_1/slope_2;
intercept_1 = ((summation_distance.*summation_velocity_sq)-(summation_velocity.*summation_velocity_distance));
intercept_2 = (r.*summation_velocity_sq - (summation_velocity.^2));
intercept = intercept_1/intercept_2;
fprintf('\nlinear equation: distance= %5.4f*velocity + %4.3f\n',slope, intercept); %prints the equation of the line. 

%OUTPUT/PLOTS:

scatter(table(:,3), table(:,2));
hold on

ordered_v = sort(velocity);

distance = slope.*ordered_v + intercept;
plot(ordered_v,distance);