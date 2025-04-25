#!/bin/bash
echo 'start'
pwd


echo 'git status'
git status

echo 'git add *'
git add -A
cur_date="git commit -a -m "`date +%Y%m%d%H%M%S`
echo $cur_date
eval $cur_date

echo 'git push origin main'
git push origin main
echo ---------------------------------------
echo 'git status'
git status
echo 按任意键退出
read -n 1
echo exit
