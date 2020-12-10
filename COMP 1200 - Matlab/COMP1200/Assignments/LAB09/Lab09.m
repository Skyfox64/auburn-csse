%John Carroll
%Lab09.m
%Due November 10th 2011
%{
    This program will read the Game results of the 2011 football season, of 
which is in an excel spreadsheet. It will then take the data and it will 
convert it into a new table. The new table will show the dates of the games 
along with which opponent was played, and whether or not it is an away 
game. It will also indicate if it is an SEC game. The program will show the 
scores and indicate them as either a win or a loss. It will display the 
games' lengths and also the number of attendees at the football games. 
Among those, it will indicate the longest game that was played, along with 
the game with the largest attendance. Finally, it will show the largest 
point spread between opponents that Auburn has won against, and lost 
against. 
%}

clc, clear all
% =======================================================================
% ******************** INPUT ********************************************
% =======================================================================
% Read excel spreadsheet
if exist('gameResults2011.xls','file')==0
    disp('File not found');
else
    [num, txt] = xlsread('gameResults2011.xls');
    [rnum,cnum] = size(num); %Numbers
    [rtxt,ctxt] = size(txt); %Text
end
%Assemble and calculate the longest game's time and also the game with the
%most attendance
max_game_time= max(3 + num(:,3)/ 60);
max_attend= max(num(:,4));
%This shows the points Auburn had over their opponent
win_spread = (num(:,1)-num(:,2));
%This shows the points that the opposing team had over Auburn
loss_spread = (num(:,2)-num(:,1));
%Finds the largest win point spread and largest loss point spread.
[max_win, max_winn] = max(win_spread);
[max_loss, max_losss] = max(loss_spread);

%Print the title headings
fprintf('                       2011 AUBURN TIGERS \n')
fprintf('             Auburn Game Results (as of Oct. 29, 2011) \n')
fprintf('\n')
fprintf('  Date             Opponent             Score  W-L Time  Attend \n')
fprintf('  -------------    ------------------   -----  --- ----  ------\n')
% =======================================================================
% ******************** Computation **************************************
% =======================================================================
for rowCount= 2:10 %For loop
    %Prints out "*" beside SEC games
    if strcmp(txt{rowCount,1} , '*') == 1;
        fprintf ('* ');
    else
        fprintf('  ');
    end

    %This displays our dates of our auburns games
    fprintf(txt{rowCount,2});
    if strcmp (txt{rowCount,3}, 'away') ==1
        fprintf(' at') ;
    else
        fprintf(' ');
    end
    fprintf('\t'); %Inserts a needed tab

    %This fprintf displays auburns opponents names
    fprintf('%-20s' , txt{rowCount,4})

    %This fprintf displays the final score of a each game
    fprintf('%2.f-%02.f', num(rowCount-1,1), num(rowCount-1,2))
    
    fprintf('\t') %Inserts a tab

    %This "if" statement displays whether auburn won or lost the game
    if num(rowCount-1,1) > num(rowCount-1,2)
        fprintf('W');
    else
        fprintf('L')
    end

    % This fprintf displays game times
    fprintf('  %1.2f' , 3 + num(rowCount-1,3)/ 60)
    if (3 + num(rowCount-1,3)/ 60) == max_game_time
        fprintf('^')
    else
        fprintf(' ')
    end

    % This displays a "#" for the highest attendance for a game
     fprintf('%6.f', num(rowCount-1,4))
    if num(rowCount-1,4) == max_attend
        fprintf('#')
    else
        fprintf(' ')
    end
    fprintf('\n')
end

% =======================================================================
% ******************** Output *******************************************
% =======================================================================
% Print the symbol legend for *, ^, and #
fprintf('  * SEC conference game \n');
fprintf('  ^ longest game \n');
fprintf('  # largest game attendance\n');
fprintf('\n'); % Inserts a Line
% Print header for "largest point spread"
fprintf('Largest point spread:\n')
%Calculates the max within wins and the losses and shows by how much, when,
%and against which opposing team
fprintf('Win:  %2.f points on %s against %-20s\n', max_win, txt{max_winn+1,2}, txt{max_winn+1,4});
fprintf('Loss: %2.f points on %s against %-20s\n' , max_loss, txt{max_losss+1,2}, txt{max_losss+1,4}) ;

