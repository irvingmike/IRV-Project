# --------------------------------------------------
# Bash Configuration and Aliases
# 16-01-31
# Aaron Anderson
# --------------------------------------------------

source ~/.profile

# --------------------------------------------------
# Terminal prompt configuration
# --------------------------------------------------

export PS1="\n---------- \d, \t --------------------------------------------------------------------\n[\u@\h]:\w\n\[$(tput bold)\]\[\033[38;5;34m\]---\[$(tput sgr0)\]\[\033[38;5;21m\]\$git_branch\$git_dirty\[$(tput sgr0)\]\[\033[38;5;34m\]->\[$(tput sgr0)\] "

# --------------------------------------------------
# Adding the git variables
# --------------------------------------------------
export GITAWAREPROMPT=~/.bash/git-aware-prompt
source "${GITAWAREPROMPT}/main.sh"


# --------------------------------------------------
# Enabling git auto-complete
# --------------------------------------------------
# source ~/git-completion.bash
if [ -f ~/.git-completion.bash ]; then
  . ~/.git-completion.bash
fi

# --------------------------------------------------
# Terminal Aliases
# --------------------------------------------------

# General Terminal Changes
alias ll='ls -FGlAhp'                   # Default to giving me whole list

# git Specific Changes
alias gp='git pull'                     # Faster git pull
alias gph='git push'                    # Faster git push
alias gs='git status'                   # Faster git status
alias gcmt='git commit -am'             # Standard git commit
alias gadd='git add .'                    # Shortcut to git add command
newGitBranch() {
    git branch $1
    git checkout $1
    git push -u
    git push --set-upstream origin $1
    git branch --set-upstream-to=origin/$1 $1
}
alias gnewb=newGitBranch

# Enterprise Java Commands
alias cdtomcat='cd /opt/tomcat'
alias cdsql='cd /usr/local/mysql/bin'
alias tcup='/opt/tomcat/bin/startup.sh'
alias tcdown='/opt/tomcat/bin/shutdown.sh'
alias installsql='mysql irv_project -u root -p < ~/irv.sql'

