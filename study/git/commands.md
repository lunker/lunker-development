# Git Commands

If you want to revert changes made to your working copy, do this:

git checkout .
If you want to revert changes made to the index (i.e., that you have added), do this. Warning this will reset all of your unpushed commits to master!:

git reset
If you want to revert a change that you have committed, do this:

git revert <commit 1> <commit 2>
If you want to remove untracked files (e.g., new files, generated files):

git clean -f
Or untracked directories (e.g., new or automatically generated directories):

git clean -fd

** gitignore 변경 후 적용
git rm -r --cached .idea/


** remove remote branch
git push origin --delete "branch명"


** remove local branch
git branch -d "branch명"
