#!/bin/sh

BASE=$(dirname -- "$(readlink -f -- "$0")" | sed "s|/tooling$||")
GAM="$BASE/game/core/src/main/java/grymV2/game"
LUWBGWGB="$BASE/game/lwjgl3/src/main/java/grymV2/game/lwjgl3"
DOC="$BASE/docs"
TOOL="$BASE/tooling"
alias togame="cd \"$GAM\""
alias tolwjgl="cd \"$LUWBGWGB\""
alias todocs="cd \"$DOC\""

fgrymd() {
    command -v fzf >/dev/null || { echo "fzf not installed"; return 2; }
    cd "$(find "$GAM" "$TOOL" "$LUWBGWGB" "$DOC" -type d | fzf -e -0 --scheme=path -n "-1" -d "/")"
}

fgrym() {
    command -v fzf >/dev/null || { echo "fzf not installed"; return 2; }
    find "$GAM" "$TOOL" "$LUWBGWGB" "$DOC" -type f | fzf -e -0 --scheme=path -n "-1" -d "/" --print0 | xargs -0 -I {} "$EDITOR" "{}"
}

alias fgrum=fgrym
alias fgrumd=fgrumd
