let SessionLoad = 1
let s:so_save = &g:so | let s:siso_save = &g:siso | setg so=0 siso=0 | setl so=-1 siso=-1
let v:this_session=expand("<sfile>:p")
silent only
silent tabonly
cd ~/git/TestAlgs/java/Queue_stack/QueueStack2
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
let s:shortmess_save = &shortmess
set shortmess=aoO
badd +1 QueueParaStack.java
badd +0 ../QueueStack.java
argglobal
%argdel
$argadd QueueParaStack.java
edit ../QueueStack.java
let s:save_splitbelow = &splitbelow
let s:save_splitright = &splitright
set splitbelow splitright
wincmd _ | wincmd |
vsplit
1wincmd h
wincmd _ | wincmd |
split
1wincmd k
wincmd w
wincmd w
wincmd _ | wincmd |
split
1wincmd k
wincmd w
let &splitbelow = s:save_splitbelow
let &splitright = s:save_splitright
wincmd t
let s:save_winminheight = &winminheight
let s:save_winminwidth = &winminwidth
set winminheight=0
set winheight=1
set winminwidth=0
set winwidth=1
exe '1resize ' . ((&lines * 37 + 21) / 42)
exe 'vert 1resize ' . ((&columns * 84 + 96) / 193)
exe '2resize ' . ((&lines * 1 + 21) / 42)
exe 'vert 2resize ' . ((&columns * 84 + 96) / 193)
exe '3resize ' . ((&lines * 28 + 21) / 42)
exe 'vert 3resize ' . ((&columns * 108 + 96) / 193)
exe '4resize ' . ((&lines * 10 + 21) / 42)
exe 'vert 4resize ' . ((&columns * 108 + 96) / 193)
argglobal
balt QueueParaStack.java
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 1 - ((0 * winheight(0) + 18) / 37)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 1
normal! 0
wincmd w
argglobal
enew
balt ../QueueStack.java
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
wincmd w
argglobal
if bufexists(fnamemodify("QueueParaStack.java", ":p")) | buffer QueueParaStack.java | else | edit QueueParaStack.java | endif
if &buftype ==# 'terminal'
  silent file QueueParaStack.java
endif
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 1 - ((0 * winheight(0) + 14) / 28)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 1
normal! 02|
wincmd w
argglobal
enew
balt QueueParaStack.java
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
wincmd w
3wincmd w
exe '1resize ' . ((&lines * 37 + 21) / 42)
exe 'vert 1resize ' . ((&columns * 84 + 96) / 193)
exe '2resize ' . ((&lines * 1 + 21) / 42)
exe 'vert 2resize ' . ((&columns * 84 + 96) / 193)
exe '3resize ' . ((&lines * 28 + 21) / 42)
exe 'vert 3resize ' . ((&columns * 108 + 96) / 193)
exe '4resize ' . ((&lines * 10 + 21) / 42)
exe 'vert 4resize ' . ((&columns * 108 + 96) / 193)
tabnext 1
if exists('s:wipebuf') && len(win_findbuf(s:wipebuf)) == 0 && getbufvar(s:wipebuf, '&buftype') isnot# 'terminal'
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20
let &shortmess = s:shortmess_save
let &winminheight = s:save_winminheight
let &winminwidth = s:save_winminwidth
let s:sx = expand("<sfile>:p:r")."x.vim"
if filereadable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &g:so = s:so_save | let &g:siso = s:siso_save
set hlsearch
nohlsearch
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
