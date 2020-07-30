using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyManager : MonoBehaviour
{
    [SerializeField] LayerMask blockLayer;
    [SerializeField] GameObject deathEffect;
    Rigidbody2D rigidbody2D;
    float speed = 0;

    public enum MOVE_DIRECTION
    {
        STOP,
        RIGHT,
        LEFT,
    }

    MOVE_DIRECTION moveDirection = MOVE_DIRECTION.RIGHT;

    private void Start()
    {
        rigidbody2D = GetComponent<Rigidbody2D>();
    }


    // Update is called once per frame
    private void Update()
    {
        if (!IsGround())
        {
            // 方向を変える
            ChangeDirection();
        }
    }

    private void FixedUpdate()
    {
        switch (moveDirection)
        {
            case MOVE_DIRECTION.STOP:
                speed = 0;
                break;
            case MOVE_DIRECTION.RIGHT:
                speed = 3;
                transform.localScale = new Vector3(1, 1, 1);
                break;
            case MOVE_DIRECTION.LEFT:
                speed = -3;
                transform.localScale = new Vector3(-1, 1, 1);
                break;
        }
        rigidbody2D.velocity = new Vector2(speed, rigidbody2D.velocity.y);
    }

    bool IsGround()
    {
        Vector3 startVec = transform.position + transform.right * 0.5f * transform.localScale.x;
        Vector3 endVec = startVec - transform.up * 0.5f;
        Debug.DrawLine(startVec, endVec);
        return Physics2D.Linecast(startVec, endVec, blockLayer);
    }

    void ChangeDirection()
    {
        if (moveDirection == MOVE_DIRECTION.RIGHT)
        {
            moveDirection = MOVE_DIRECTION.LEFT;
        }
        else
        {
            moveDirection = MOVE_DIRECTION.RIGHT;
        }
    }
    public void DestroyEnemy()
    {
        Instantiate(deathEffect, this.transform.position, this.transform.rotation);
        Destroy(this.gameObject);
    }
}
