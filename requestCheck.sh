start=$SECONDS

for i in {0..100}
    do
        curl -X GET  https://polar-fjord-37505.herokuapp.com/action &
    done
wait

duration=$(( SECONDS - start ))

echo $duration