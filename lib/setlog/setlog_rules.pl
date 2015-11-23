
% Version 1.0

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% User-defined rewriting rules
% for {log} version 4.7.0-1 or newer
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%           by Maximiliano Cristia' and  Gianfranco Rossi
%                          September 2013 
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%inference_rule(W: when,
% 		C: atomic constraint to be rewritten
%		C_Conds: list of conditions for C
%               D: list of other atomic constraints to be checked
%               D_Conds: list of conditions for atomic constraints in D and C
%               E: list of constraints in D to be excluded
%               AddC: constraint to be added or false
		

%%%%%%%%%% Sample rules %%%%%%%%%%
%%%%%%%%%% (already applied at run-time by the solver) %%%%%%%%%%

% disj(R,S) --> set(R) & set(S)
inference_rule(initial,disj(R,S),[],[],[],[], (type(set(R)) & type(set(S))) ).

% size(S,N) & size(V,M) --> N = M
inference_rule(initial,size(S,N),[var(S)],[size(V,M)],[V==S],[size(S,N)], N=M).

% set(X) & integer(X)  --> false
inference_rule(initial,set(X),[var(X)],[integer(V)],[V==X],[], a=b).


%%%%%%%%%% General rules %%%%%%%%%%

% X < Y & X > Y  --> false
inference_rule(initial,X < Y,[],[V > W],[V==X,W==Y],[], a=b).


%%%%%%%%%% For the TTF %%%%%%%%%%

% DomNotSubsetOfSingleton
% is_rel(R) & R neq {} & dom(R,D) & ssubset(D,{X})
inference_rule(initial,ssubset(D,{} with _X),[],[dom(R,DD),is_rel(RR),RRR neq {}],[R==RR,RR==RRR,D==DD],[],a=b).

% DresCapEqual
% is_rel(R) & R neq {} & dom(R,D) & A = D & dres(A,R,Q) & inters(R,Q,{})
inference_rule(initial,dres(A,R,Q),[],[inters(R2,QQ,{}),dom(R3,D),AA=DD,is_rel(R4),R5 neq {}],[R==R2,R2==R3,Q==QQ,A==AA,D==DD,R3==R4,R4==R5],[],a=b).

% DresEmpty2
% is_rel(R) & A = {} & dres(A,R,Q) & dom(Q,D) & D neq {}
inference_rule(initial,dres(A,R,Q),[],[AA={},is_rel(RR),dom(QQ,D),DD neq {}],[A==AA,R==RR,Q==QQ,D==DD],[],a=b).

% DresEmpty
% is_rel(R) & A = {} & dres(A,R,Q) & Q neq {}
inference_rule(initial,dres(A,R,Q),[],[AA={},is_rel(RR),QQ neq {}],[A==AA,R==RR,Q==QQ],[],a=b).

% DresEqual
% is_rel(R) & R neq {} & dom(R,D) & A = D & dres(A,R,{})
inference_rule(initial,dres(A,R,{}),[],[dom(R2,D),AA=DD,is_rel(R3),R4 neq {}],[A==AA,R==R2,R2==R3,R3==R4,D==DD],[],a=b).

% DresSubsetEqual
% is_rel(R) & R neq {} & dom(R,D) & A = D & dres(A,R,Q) & ssubset(R,Q)
%inference_rule(initial,dres(A,R,Q),[],[ssubset(R2,QQ),is_rel(R3),R4 neq {},dom(R5,D),AA=DD],[R==R2,R2==R3,R3==R4,R4==R5,A==AA,D==DD,Q==QQ],[],a=b).
%%%%%%%%% not necessary

% ExtensionalUndefinition
% dom(F,D) & X nin D & apply(F,X,Y)
inference_rule(initial,apply(F,X,_Y),[var(X)],[dom(FF,D),XX nin DD],[F==FF,X==XX,D==DD],[],a=b).

% NrresCap
% is_rel(R) & nrres(A,R,Q) & dom(Q,DQ) & X in DQ & dom(R,D) & inters({X / B},D,{}) 
%inference_rule(initial,nrres(_A,R,Q),[],[inters(_B with X,D,{}),is_rel(R2),dom(R3,D2),dom(Q2,DQ),X2 in DQ2], [R==R2,R2==R3,D==D2,Q==Q2,DQ==DQ2,X==X2],[],a=b).
%%%%%%%%% problems with multiple occurrences of the same predicate dom/2

% RanNotSubsetOfSingleton
% is_rel(R) & R neq {} & ran(R,Ran) & ssubset(Ran,{Y})
inference_rule(initial,ssubset(Ran,{} with _Y),[],[ran(R,Ran2),is_rel(R2),R3 neq {}],[R==R2,R2==R3,Ran==Ran2],[],a=b).

% RresEmpty2
% is_rel(R) & A = {} & rres(A,R,Q) & dom(Q,DQ) &  DQ neq {}
inference_rule(initial,rres(A,R,Q),[],[AA={},is_rel(RR),dom(QQ,DQ),DDQ neq {}],[A==AA,R==RR,Q==QQ,DQ==DDQ],[],a=b).

% RresEmpty4
% is_rel(R) & ran(R,RRan) & inters(A,RRan,{}) & rres(A,R,Q) & dom(Q,DQ) &  DQ neq {}
inference_rule(initial,rres(A,R,Q),[],[inters(AA,RRan,{}),is_rel(RR),ran(RR,RRRan),dom(QQ,DQ),DDQ neq {}],[A==AA,R==RR,Q==QQ,DQ==DDQ,RRan==RRRan],[],a=b).

% SingletonMappletNotEqualRel1
% is_rel(R) & R = {[X,Y] / Q} & dom(R,D) & X nin D
inference_rule(initial,R = _Q with [X,_Y],[],[dom(R2,D),is_rel(R3),X2 nin D2],[R==R2,R2==R3,D==D2,X==X2],[],a=b).

% SingletonMappletNotInDom
% is_rel(R) & dom(R,D) & X nin D & dom({[X,Y] / B},DS) & D = DS
inference_rule(initial,dom(_B with [X,_Y],DS),[],[dom(R,D),is_rel(R2),X2 nin D2,D3=DS2],[R==R2,D==D2,D2==D3,X==X2,DS==DS2],[],a=b).

% SingletonNotSubsetDom
% is_rel(R) & dom(R,D) & X nin D & dom({[X,Y] / B},DS) & ssubset(DS,D)

inference_rule(initial,dom(_B with [X,_Y],DS),[],[dom(R,D),is_rel(R2),X2 nin D2,ssubset(DS2,D3)],[R==R2,D==D2,D2==D3,X==X2,DS==DS2],[],a=b).

% SingletonNotSubsetRel.pl
% is_rel(R) & ssubset({[X,Y] / Q},R) & dom(R,D) & X nin D

inference_rule(initial,ssubset(_Q with [X,_Y],R),[],[dom(R2,D),is_rel(R3),X2 nin D2],[R==R2,R2==R3,D==D2,X==X2],[],a=b).
