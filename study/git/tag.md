# GIT Tag commands

## create tag 
git tag -a <tag명> -m <tag message> <commit id>


## delete all tags
git tag | xargs git tag -d


## push tag
git push origin <tag명>


## git delete local tag
git tag -d <tag name>

## git delete remote tag
git push origin :<tag name>
