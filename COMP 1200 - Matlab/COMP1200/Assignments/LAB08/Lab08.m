% John Carroll
% Lab08.m
% Due November 3rd 2011
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

    Using Hubble’s data, the program finds the linear equation that estimates the 
relationship between the velocity and distance readings. It also, displays 
the data on a graph using two defined functions to compute the slope and 
y-intercept.
%}
 
 


clc
clear all



% =======================================================================
% ***** INPUT *****
%Read Hubble's data from hubbleData.txt

fid = exist('hubbleData.txt','file');

if fid > 0
    [distance, velocity] = textread('hubbleData.txt','%*f %f %f %*f %*f');
    [slope, intercept] = compSlopeIntercept(velocity, distance);
    r = length(distance);
    % Print the two column table with velocity and distance values
    fprintf('\n   NEBULA INPUT DATA \n VELOCITY    DISTANCE \n   km/sec  106 parsecs \n');
    for m = 1 : r
        fprintf('    %4d    %5.3f\n', velocity(m), distance(m));
    end
    
    plotHubbleData(velocity, distance, slope, intercept);

    inputVelocity = input('Enter the velocity from a nebula above:');
    
    if ismember (inputVelocity, velocity)
        distance_eq = slope * inputVelocity + intercept;
    else %if entered a bad velocity
        while ~ismember (inputVelocity, velocity)
            inputVelocity = input('Enter the velocity from a nebula above:');
        end
        distance_eq = slope * inputVelocity + intercept; % =Distance equation
    end
    fprintf('For velocity = %4d, distance = %5.3f\n', inputVelocity, distance_eq)
else
    disp('File is bad'); %This is printed if something is wrong with the file
end