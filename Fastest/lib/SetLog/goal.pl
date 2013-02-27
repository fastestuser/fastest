use_module(library(dialect/sicstus/timeout)).
consult(setlog4616).
consult_lib.
time_out(setlog(
A in int(0,5) &
A > 3 
,_CONSTR),1000,_RET).
