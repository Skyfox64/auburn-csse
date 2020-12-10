%John Carroll
%Lab10.m
%Due November 17th 2011
%{
    This program will read the the number of touchdowns, extra points, and 
field goals made by Auburn which is shown on the "teamStat" spreadsheet in 
auburnStats2011.xls. It will compute the points made, and write a summary 
on the "pointSummary" spreadsheet in auburnStats2011.xls. It will also 
create a stacked bar chart and pie chart to compare the category points.
%}

clc, clear all
% =======================================================================
% ******************** INPUT ********************************************
% =======================================================================
% Check to see if file exists
if exist ('auburnStats2011.xls','file') == 0
    disp('file not found')
    %This defines our text and number arrays
else column = 8;
    [num, txt] = xlsread('auburnStats2011.xls');
    [rnum,cnum] = size(num);
    [rtxt,ctxt] = size(txt);
end
%games=9;
% =======================================================================
% ******************** Computation **************************************
% =======================================================================
Rush_TD= num(:,1)*6;
Total_Rush_TD= sum(Rush_TD);

Pass_TD= num(:,2)*6;
Total_Pass_TD= sum(Pass_TD);

Kick_Ret_TD= num(:,3)*6;
Total_Kick_Ret_TD= sum(Kick_Ret_TD);

Xtra_Pt= num(:,4)*1;
Total_Xtra_Pt= sum(Xtra_Pt);

Fld_Goal= num(:,5)*3;
Total_Fld_Goal= sum(Fld_Goal);

Total_Pts= sum(Rush_TD+Pass_TD+Kick_Ret_TD+Xtra_Pt+Fld_Goal);

Percent_Rush_TD= (Total_Rush_TD/Total_Pts)*100;
Percent_Pass_TD= (Total_Pass_TD/Total_Pts)*100;
Percent_Kick_Ret_TD= (Total_Kick_Ret_TD/Total_Pts)*100;
Percent_Xtra_Pt= (Total_Xtra_Pt/Total_Pts)*100;
Percent_Fld_Goal= (Total_Fld_Goal/Total_Pts)*100;

A= Percent_Rush_TD;
B= Percent_Pass_TD;
C= Percent_Kick_Ret_TD;
D= Percent_Xtra_Pt;
E= Percent_Fld_Goal;

game_score= (Rush_TD+Pass_TD+Kick_Ret_TD+Xtra_Pt+Fld_Goal);

% =======================================================================
% ******************** Output *******************************************
% =======================================================================
% prepares headers and game dates for the output Excel sheet

Output(1:rtxt,1) = txt(1:rtxt,1);
Output(1:rtxt,2) = txt(1:rtxt,3);
Output(1,2:ctxt-1) = txt(1,3:ctxt);
Output(1,8) = {'Game Points'};


%prepares the numeric data for the output excel sheet
games= size(txt(2:end,1));
for index = 1:games
    Output(index+1,3)={Rush_TD(index)};
    Output(index+1,4)={Pass_TD(index)};
    Output(index+1,5)={Kick_Ret_TD(index)};
    Output(index+1,6)={Xtra_Pt(index)};
    Output(index+1,7)={Fld_Goal(index)};
    Output(index+1,8)={game_score(index)};
end
Output(rnum+2,2)={'Category Points'};
Output(rnum+1,3)={Total_Rush_TD};
Output(rnum+1,4)={Total_Pass_TD};
Output(rnum+1,5)={Total_Kick_Ret_TD};
Output(rnum+1,6)={Total_Xtra_Pt};
Output(rnum+1,7)={Total_Fld_Goal};
xlswrite('auburnStats2011.xls',Output,'pointSummary');
q=[Rush_TD Pass_TD Kick_Ret_TD Xtra_Pt Fld_Goal];

% This plots our percentages from above into a pie graph
subplot(2,1,1)
x=[A B C D E];
pie(x)
% Legend and title for our pie graph
legend('Rush TD', 'Pass TD','Kick Ret TD','Extra TD','Fld Goal')
title('Auburn Tigers 2011')

subplot(2,1,2) % Creates a place for our scatter plot

%This takes our numbers from our number array and plots it in a stacked bar
%graph
g=(q);
bar(q,'stack')

xlabel('Games') % X-Label
ylabel('Points') % Y-label
% Creates our legend and title for our scatter plot
Legend('Rush TD', 'Pass TD','Kick Ret TD','Extra TD','Fld Goal')
title('Auburn Tigers 2011')
text(1,45,sprintf('Season stat: %.1f %%  pts passing, %.1f %% pts rushing', (max(Percent_Rush_TD)), (max(Percent_Pass_TD))))








